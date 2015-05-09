package opr.client.ui;

import java.util.List;

import opr.shared.OperatoerDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ListView extends Composite {
	
	private VerticalPanel vPanel = new VerticalPanel();
	private Anchor remove;
	private Anchor edit;
	private List<OperatoerDTO> list;
	
	
	
	@SuppressWarnings("deprecation")
	public ListView(final MainView main) throws Exception {
		initWidget(vPanel);
		HorizontalPanel hPanel = new HorizontalPanel();
		
		main.getService().getOperatoerList(new AsyncCallback<List<OperatoerDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to access databse: "+caught.getMessage());
			}

			@Override
			public void onSuccess(List<OperatoerDTO> result) {
				list = result;
			}
			
		});
		
		edit = new Anchor();
		edit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				main.openEditView();			
			}
			
		});
		
		remove = new Anchor();
		remove.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				main.getService().deleteOperatoer(p, callback);
			}
			
		});
		
		
	}
}
