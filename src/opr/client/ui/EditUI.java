package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class EditUI extends Composite {

	private static EditUIUiBinder uiBinder = GWT.create(EditUIUiBinder.class);

	interface EditUIUiBinder extends UiBinder<Widget, EditUI> {
	}

	public EditUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
