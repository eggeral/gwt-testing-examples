package egger.software.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EchoServiceAsync
{
    void echo( String message, AsyncCallback<String> callback );
}
