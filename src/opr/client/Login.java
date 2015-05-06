package opr.client;

import opr.client.service.ILoginServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	Label lblOne = new Label("User ID ");
	Label lblTwo = new Label("Password ");
	TextBox userID = new TextBox();
	TextBox password = new TextBox();

	public interface Callback{
		public void loginSucces(OperatoerDTO activeUser);
		public void loginFailiure();
	}


	public Login(final Callback c, final ILoginServiceAsync x){
		//this.c = c;
		this.initWidget(vPanel);
		vPanel.add(lblOne);
		vPanel.add(userID);
		vPanel.add(lblTwo);
		vPanel.add(password);

		Button btnOne = new Button("Submit", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {
					vPanel.add(new Label("test1"));

					x.loginVerify(Integer.parseInt(userID.getText()), password.getText(), new AsyncCallback<OperatoerDTO>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl! " + caught.getMessage());
						}
						@Override
						public void onSuccess(OperatoerDTO data) {
							vPanel.add(new Label("test2"));
							vPanel.add(new Label(data.getOprNavn()));
							
							if(data.getOprId() >= 0){
								vPanel.add(new Label("test3"));
								c.loginSucces(data);
								vPanel.add(new Label(data.getOprNavn()));
							}else{
								c.loginFailiure();
							}
						}


					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});

		vPanel.add(btnOne);	


	}
	public String getUName() {
		return userID.getText();
	}
	public String getPassW() {
		return password.getText();
	}
}
