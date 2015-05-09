package opr.client.uiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;

public class EditUI extends Composite {

	private static EditUIUiBinder uiBinder = GWT.create(EditUIUiBinder.class);
	@UiField Button confirmEdit;
	@UiField TextBox newIDBox;
	@UiField TextBox newNameBox;
	@UiField Label newIDBoxLabel;
	@UiField Label newNameBoxLabel;

	interface EditUIUiBinder extends UiBinder<Widget, EditUI> {
	}

	public EditUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
