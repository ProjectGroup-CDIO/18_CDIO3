package opr.client.uiBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class LoginUI extends Composite {

	private static LoginUIUiBinder uiBinder = GWT.create(LoginUIUiBinder.class);

	interface LoginUIUiBinder extends UiBinder<Widget, LoginUI> {
	}

	public LoginUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
