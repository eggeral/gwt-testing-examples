package egger.software.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("echo")
public interface EchoService extends RemoteService {
	String echo(String message) throws IllegalArgumentException;
}
