package egger.software.gwt.client.helloworld;

import com.google.gwt.user.client.rpc.AsyncCallback;
import egger.software.gwt.client.EchoServiceAsync;

public class Action {

    private Ui ui;
    private EchoServiceAsync echoService;

    public Action(Ui ui, EchoServiceAsync echoService) {
        this.ui = ui;
        this.echoService = echoService;
    }

    public void echoMessage(String message) {
        echoService.echo(message, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                ui.updateErrorText("Error: " + caught.getMessage());
                ui.setRequestPending(false);
            }

            public void onSuccess(String result) {
                ui.updateResultText(result);
                ui.setRequestPending(false);

            }
        });
    }
}
