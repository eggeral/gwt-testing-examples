package egger.software.gwt.server;

import egger.software.gwt.client.EchoService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EchoServiceImpl extends RemoteServiceServlet implements EchoService {

	public String echo(String message) throws IllegalArgumentException {
		return message;
	}
}
