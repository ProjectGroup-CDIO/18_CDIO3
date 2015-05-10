package opr.client.ui;

import java.util.ArrayList;
import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListView extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel();
	private Anchor remove;
	private Anchor edit;
	private List<OperatoerDTO> l;
	private ArrayList<HorizontalPanel> al;
	

	
	public ListView(final MainView main) throws Exception {
		initWidget(this.vPanel);
		final FlexTable ft = new FlexTable();
		final FlexCellFormatter ftFormat = ft.getFlexCellFormatter();
		ftFormat.setWidth(0, 0, "50px");
		ftFormat.setWidth(0, 1, "200px");
		ft.setBorderWidth(1);
		
		ft.setText(0, 0, "Opr ID");
		ft.setText(0, 1, "Navn");
		
		main.getService().getOperatoerList(new AsyncCallback<List<OperatoerDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				l = result;
				for(int i = 0; i < l.size(); i++) {
					ft.setText(i+1, 0, String.valueOf(l.get(i).getOprId()));
					ft.setText(i+1, 1, l.get(i).getOprNavn());
					ft.setWidget(i+1, 2, new RadioButton("check 'em", ""));
				}
			}
			
		});
		Button editBtn = new Button("Edit");
		editBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				for(int i = 0; i < l.size(); i++) {
					RadioButton btn = (RadioButton) ft.getWidget(i+1, 2);
					if(btn.getValue()) {
						try {
							main.openEditView(i+1);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
			
		});
		
		edit = new Anchor();
		edit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				main.openEditView();			
			
			}
			
		});
		
		remove = new Anchor();
//		remove.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				main.getService().deleteOperatoer(p, callback);
//			}
//			
//		});
		vPanel.add(ft);
		
	}

	public void fillList() {
		Label l1;
		Label l2;
		al = new ArrayList<HorizontalPanel>();
		
		for(int i = 0; i < l.size(); i++) {
			l1 = new Label(String.valueOf(l.get(i).getOprId()));
			l2 = new Label(String.valueOf(l.get(i).getOprNavn()));
			HorizontalPanel hPanel = new HorizontalPanel();
			hPanel.add(l1);
			hPanel.add(l2);
			hPanel.add(edit);
			hPanel.add(remove);
			al.add(hPanel);
		}
	}
	
}
