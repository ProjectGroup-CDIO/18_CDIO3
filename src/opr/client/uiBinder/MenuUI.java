package opr.client.uiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;

public class MenuUI extends Composite{

	private static MenuUIUiBinder uiBinder = GWT.create(MenuUIUiBinder.class);
	@UiField VerticalPanel menuViewVPanel;
	@UiField Button menuViewLogout;
	@UiField Button menuViewEdit;
	@UiField Button menuViewList;
	@UiField Button menuViewAdd;
	@UiField Button menuViewInactive;

	interface MenuUIUiBinder extends UiBinder<Widget, MenuUI> {
	}

	public MenuUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
