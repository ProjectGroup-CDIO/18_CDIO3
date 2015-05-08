package opr.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainViewUIB extends Composite {

	private static MainViewUIBUiBinder uiBinder = GWT
			.create(MainViewUIBUiBinder.class);
	@UiField Button button;
	@UiField VerticalPanel contenPannel;

	interface MainViewUIBUiBinder extends UiBinder<Widget, MainViewUIB> {
	}

	public MainViewUIB() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
	}
}
