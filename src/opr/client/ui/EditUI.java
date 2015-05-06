package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class EditUI extends Composite {

	private static EditUIUiBinder uiBinder = GWT.create(EditUIUiBinder.class);

	interface EditUIUiBinder extends UiBinder<Widget, EditUI> {
	}

	public EditUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiHandler("uiLogout")
	void onUiLogoutClick(ClickEvent event) {
	}
}
