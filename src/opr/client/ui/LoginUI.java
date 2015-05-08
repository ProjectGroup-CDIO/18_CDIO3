package opr.client.ui;

import opr.client.Login.Callback;
import opr.client.service.ILoginServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginUI extends Composite {

	private static LoginUIUiBinder uiBinder = GWT.create(LoginUIUiBinder.class);
	@UiField Button button;
	@UiField PasswordTextBox pass;
	@UiField TextBox userId;
	@UiField Label labelLogin;
	@UiField Label labelPass;
	@UiField VerticalPanel vPanel;

	interface LoginUIUiBinder extends UiBinder<Widget, LoginUI> {
		public void loginSucces(OperatoerDTO activeUser);
		public void loginFailiure();
	}
	

	public LoginUI(final Callback c, final ILoginServiceAsync x) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
	@UiHandler("button")
	void onButtonClick(ClickEvent event) 
	{try {
		vPanel.add(new Label("test1"));
		
		x.loginVerify(Integer.parseInt(userId.getText()), pass.getText(), new AsyncCallback<OperatoerDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Server fejl! " + caught.getMessage());
				userId.setText("");
				pass.setText("");
			}
			@Override
			public void onSuccess(OperatoerDTO data) {
				vPanel.add(new Label("test2"));
				vPanel.add(new Label(data.getOprNavn()));
				
				if(data.getOprId() >= 0){
					vPanel.add(new Label("test3"));
					c.loginSucces(data);
					vPanel.add(new Label(data.getOprNavn()));
				}
			}
		});
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
