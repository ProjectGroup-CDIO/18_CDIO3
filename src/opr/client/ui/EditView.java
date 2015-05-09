package opr.client.ui;

import opr.shared.OperatoerDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class EditView extends Composite {
	private FlexTable ft = new FlexTable();
	private Label lblCPR = new Label ("CPR");
	private TextBox txtBoxCPR = new TextBox();
	private Label lblNavn = new Label ("Navn");
	private TextBox txtBoxNavn = new TextBox();
	private Label lblPassword = new Label ("Password");
	private TextBox txtBoxPassword = new TextBox();
	private OperatoerDTO opr;
	
	public EditView(final MainView main, final int oprID) throws Exception{
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
		
		//ikke testet
		opr = new OperatoerDTO(oprID, txtBoxNavn.getText(), "ini??",
				txtBoxCPR.getText(), txtBoxPassword.getText());
		
		Button btnEdit = new Button("Edit", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				
				//ikke testet
				try {
					main.getService().updateOperatoer(opr, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Error: "+caught.getMessage());
							
						}

						@Override
						public void onSuccess(Void result) {
							Window.alert("Successfully updated operator");
						}
						
					});
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			try{
				
			} catch (Exception e){
				e.printStackTrace();
			}
				
		}
			
	});
		ft.setWidget(2, 4, btnEdit);
}
		
	
}
