package opr.client;


import com.Assignment3.client.service.ILoginService;
import com.Assignment3.client.service.ILoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



public class MainView extends Composite implements Login.Callback{

	private VerticalPanel vPanel = new VerticalPanel();
	private Login login;
	String UName = "";
	String PW = "";
	final ILoginServiceAsync x = GWT.create(ILoginService.class);

	public MainView() throws Exception{


		initWidget(this.vPanel);
		this.login = new Login(this,x);
		Label lblOne = new Label("Please write in your login info. ");
		this.vPanel.add(lblOne);
		this.vPanel.add(login);

		

	}

	public void loginSucces(String UName, String passW) {
		this.vPanel.clear();
		HelloWorld ellloooo = new HelloWorld(UName,PW);
		this.vPanel.add(ellloooo);

	}
	public void loginFailiure(){
		
	}

}
