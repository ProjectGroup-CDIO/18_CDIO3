package opr.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuScreen extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	String Uname;
	String Pword;
	
	
	

	public MenuScreen(String Username, String Password){
		this.initWidget(vPanel);
		Uname = Username;
		Pword = Password;
		//vPanel.clear();
		Label lblOne = new Label("Username:" + Uname + " Password:"+Pword);
		vPanel.add(lblOne);
		
		
	}
}
