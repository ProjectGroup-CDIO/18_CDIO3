package opr.client.ui;

import opr.client.service.IOperatoerService;
import opr.client.service.IOperatoerServiceAsync;
import opr.shared.OperatoerDTO;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainView extends Composite implements Login.Callback {
	
	private OperatoerDTO activeUser;
	private FlexTable ft = new FlexTable();
	private FlexCellFormatter ftFormat = ft.getFlexCellFormatter();
	private VerticalPanel content = new VerticalPanel();
	private Login login;
//	private ListView list;
	private MenuView menu;
//	private EditView edit;
	private AddView add;
	private final IOperatoerServiceAsync service = GWT.create(IOperatoerService.class);
	
	public MainView() throws Exception {
		initWidget(ft);
		login = new Login(this);
		ft.setWidget(0,0,login);
		
//		list = new ListView(this);
//		ft.setWidget(0, 1, list);
		ft.setBorderWidth(1);
		ft.setWidget(0, 1, login);
	}
	
	//ikke testet
	public void openEditView(int oprId) throws Exception {
		content.clear();
		content.add(new EditView(this, oprId));
		ft.setWidget(0,1,content);
	}
	
	public void openAddView() throws Exception{
		content.clear();
		add = new AddView(this);
		content.add(add);
		ft.setWidget(0, 1, content);
	}
	
	public void openLoginView() {
		
	}
	
	public void openListView() throws Exception {
		content.clear();
		content.add(new ListView(this));
		ft.setWidget(0, 1, content);
	}
	
	@Override
	public IOperatoerServiceAsync getService() {
		return service;
	}
	
	@Override
	public void loginSucces(OperatoerDTO activeUser) {
		ft.clear();
		this.activeUser = activeUser;
		menu = new MenuView(this);
		ft.setWidget(0,0,menu);
		
	}

	@Override
	public void loginFailiure() {
		// TODO Auto-generated method stub
		
	}
	
	
}
