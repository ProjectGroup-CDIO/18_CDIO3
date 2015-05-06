package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SetInactiveUI extends Composite{

	private static SetInactiveUIUiBinder uiBinder = GWT
			.create(SetInactiveUIUiBinder.class);
	@UiField Button button;

	interface SetInactiveUIUiBinder extends UiBinder<Widget, SetInactiveUI> {
	}

	public SetInactiveUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
	}
}
