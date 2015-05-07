package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ListBox;

public class ListUI extends Composite {

	private static ListUIUiBinder uiBinder = GWT.create(ListUIUiBinder.class);
	@UiField ListBox listBox;

	interface ListUIUiBinder extends UiBinder<Widget, ListUI> {
	}

	public ListUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
