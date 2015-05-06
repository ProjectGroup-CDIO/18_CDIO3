package opr.client;


import opr.client.service.ILoginService;
import opr.client.service.ILoginServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;


public class MainView extends Composite implements Login.Callback{

	private OperatoerDTO activeUser;
	private VerticalPanel vPanel = new VerticalPanel();
	private Login login;
	String UName = "";
	String PW = "";
	final ILoginServiceAsync x = GWT.create(ILoginService.class);
	

	public MainView() {

		

		initWidget(this.vPanel);
		this.login = new Login(this,x);
		Label lblOne = new Label("Please write in your login info. ");
		this.vPanel.add(lblOne);
		this.vPanel.add(login);

		

	}

	public void loginFailiure(){
		
	}

	@Override
	public void loginSucces(OperatoerDTO activeUser) {
		vPanel.clear();
		this.activeUser = activeUser;
		
	}

}
