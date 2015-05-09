package opr.client.ui;

import opr.client.service.IOperatoerService;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite implements Login.Callback {
	
	private OperatoerDTO activeUser;
	private FlexTable ft = new FlexTable();
	private FlexCellFormatter ftFormat = ft.getFlexCellFormatter();
	private VerticalPanel content = new VerticalPanel();
	private Login login;
	private ListView list;
	private MenuView menu;
	private EditView edit;
	private final IOperatoerServiceAsync service = GWT.create(IOperatoerService.class);
	
	public MainView() {
		initWidget(ft);
		
	}
	
	public void openEditView() {
		content.clear();
		content.add(edit);
	}

	public IOperatoerServiceAsync getService() {
		return service;
	}
	
	@Override
	public void loginSucces(OperatoerDTO activeUser) {
		ft.clear();
		this.activeUser = activeUser;
		
	}

	@Override
	public void loginFailiure() {
		// TODO Auto-generated method stub
		
	}
	
	
}
