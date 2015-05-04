package opr.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HelloWorld extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	String Uname;
	String Pword;
	
	
	

	public HelloWorld(String Username, String Password){
		this.initWidget(vPanel);
		Uname = Username;
		Pword = Password;
		//vPanel.clear();
		Label lblOne = new Label("Username:" + Uname + " Password:"+Pword);
		vPanel.add(lblOne);
		
		
	}
}
