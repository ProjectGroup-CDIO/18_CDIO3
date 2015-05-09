package opr.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;

public class EditView extends Composite {
	private FlexTable ft = new FlexTable();
	Label lblCPR = new Label ("CPR");
	TextBox txtBoxCPR = new TextBox();
	Label lblNavn = new Label ("Navn");
	TextBox txtBoxNavn = new TextBox();
	Label lblPassword = new Label ("Password");
	TextBox txtBoxPassword = new TextBox();
	
	public EditView(MainView mainView) throws Exception{
		this.initWidget(ft);
		
		ft.setWidget(0, 0, lblCPR);
		ft.setWidget(0, 1, lblNavn);
		ft.setWidget(0, 2, lblPassword);
		
		txtBoxCPR.setEnabled(true);
		txtBoxNavn.setEnabled(true);
		txtBoxPassword.setEnabled(true);
		ft.setWidget(1, 0, txtBoxCPR);
		ft.setWidget(1, 1, txtBoxNavn);
		ft.setWidget(1, 2, txtBoxPassword);
		
		Button btnEdit = new Button("Edit", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
			
			try{
				
				
			} catch (Exception e){
				e.printStackTrace();
			}
				
		}
			
	});
		ft.setWidget(2, 4, btnEdit);
}
		
	
}
