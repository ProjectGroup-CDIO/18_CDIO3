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
	Label lblOne = new Label("Username ");
	Label lblTwo = new Label("Password ");
	TextBox username = new TextBox();
	TextBox password = new TextBox();

	public interface Callback{
		public void loginSucces(String UName, String PassW);
		public void loginFailiure();
	}


	public Login(final Callback c, final ILoginServiceAsync x){
		//this.c = c;
		this.initWidget(vPanel);
		vPanel.add(lblOne);
		vPanel.add(username);
		vPanel.add(lblTwo);
		vPanel.add(password);

		Button btnOne = new Button("Submit", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {

					x.loginVerify(new OperatoerDTO(username.getText(), password.getText()), new AsyncCallback<Boolean>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Server fejl! " + caught.getMessage());
						}
						@Override
						public void onSuccess(Boolean result) {
							if(result){
								vPanel.clear();
								vPanel.add(new Label("U have logged in - please wait for login screen."));
							}else{
								vPanel.add(new Label("Wrong username and/or password"));
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
		return username.getText();
	}
	public String getPassW() {
		return password.getText();
	}
}
