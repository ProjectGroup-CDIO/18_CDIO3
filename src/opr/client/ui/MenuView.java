package opr.client.ui;

import opr.client.ui.MainView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();
	Label testLBL = new Label("TEST ONE -");
	Label testLBL2 = new Label("TEST TWO -");

	public MenuView(final MainView mainView){
		this.initWidget(vPanel);
		
		vPanel.add(testLBL);
		vPanel.add(testLBL2);
		vPanel.setBorderWidth(1);
		
	
		Button addBtn = new Button("ADD", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
				try {
					mainView.openAddView();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		});
		Button editBtn = new Button("EDIT", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
			}
		
		});
		Button removeBtn  = new Button("REMOVE", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
			}
		
		});
		Button listBtn = new Button("LIST", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
			}
		
		});
		
		editBtn.setPixelSize(100, 30);
		removeBtn.setPixelSize(100, 30);
		addBtn.setPixelSize(100, 30);
		listBtn.setPixelSize(100, 30);
		vPanel.add(editBtn);
		vPanel.add(removeBtn);
		vPanel.add(addBtn);
		vPanel.add(listBtn);	
		
		
		
		
		
	}
}



