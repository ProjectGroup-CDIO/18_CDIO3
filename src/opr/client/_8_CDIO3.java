package opr.client;

import opr.server.impl.MySQLOperatoerDAO;
import opr.server.interfaces.OperatoerDAO;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class _8_CDIO3 implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	
	
		
		
		MainView mainView = new MainView();
		RootPanel.get().add(mainView);
	}
}
