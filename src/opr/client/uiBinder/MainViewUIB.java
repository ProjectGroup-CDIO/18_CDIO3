package opr.client.uiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.DockPanel;

public class MainViewUIB extends Composite {

	private static MainViewUIBUiBinder uiBinder = GWT
			.create(MainViewUIBUiBinder.class);

	interface MainViewUIBUiBinder extends UiBinder<Widget, MainViewUIB> {
	}

	public MainViewUIB() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
