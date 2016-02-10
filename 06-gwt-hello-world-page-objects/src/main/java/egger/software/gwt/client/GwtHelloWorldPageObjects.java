package egger.software.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import egger.software.gwt.client.helloworld.Action;
import egger.software.gwt.client.helloworld.Ui;

public class GwtHelloWorldPageObjects implements EntryPoint {
	private final EchoServiceAsync echoService = GWT.create(EchoService.class);

	public void onModuleLoad() {

		Ui ui = new Ui();
		Action action = new Action(ui, echoService);

		ui.layout();
		ui.connectEvents(action);

	}
}
