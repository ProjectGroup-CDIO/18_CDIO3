package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;

public class EditUI extends Composite {

	private static EditUIUiBinder uiBinder = GWT.create(EditUIUiBinder.class);
	@UiField Button uiList;
	@UiField Button uiInactive;
	@UiField Button uiEdit;
	@UiField Button uiAdd;
	@UiField Button uiLogout;
	@UiField Button uiEdit_2;

	interface EditUIUiBinder extends UiBinder<Widget, EditUI> {
	}

	public EditUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiHandler("uiLogout")
	void onUiLogoutClick(ClickEvent event) {
	}
}
