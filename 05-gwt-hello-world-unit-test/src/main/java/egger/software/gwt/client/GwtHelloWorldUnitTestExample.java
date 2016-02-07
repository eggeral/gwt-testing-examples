package egger.software.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import egger.software.gwt.client.helloworld.Action;
import egger.software.gwt.client.helloworld.Ui;

public class GwtHelloWorldUnitTestExample implements EntryPoint {
    private final EchoServiceAsync echoService = GWT.create(EchoService.class);

	public void onModuleLoad() {

        Ui ui = new Ui();
        Action action = new Action(ui, echoService);

        ui.layout();
        ui.connectEvents(action);

	}
}
