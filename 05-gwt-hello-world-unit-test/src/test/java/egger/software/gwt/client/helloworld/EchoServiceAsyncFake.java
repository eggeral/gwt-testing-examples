package egger.software.gwt.client.helloworld;

import com.google.gwt.user.client.rpc.AsyncCallback;
import egger.software.gwt.client.EchoServiceAsync;

public class EchoServiceAsyncFake implements EchoServiceAsync {

    private boolean generateFailure;

    public EchoServiceAsyncFake(boolean generateFailure) {
        this.generateFailure = generateFailure;
    }

    @Override
    public void echo(String message, AsyncCallback<String> callback) {
        if (!generateFailure)
            callback.onSuccess(message);
        else
            callback.onFailure(new IllegalStateException(message));
    }
}
