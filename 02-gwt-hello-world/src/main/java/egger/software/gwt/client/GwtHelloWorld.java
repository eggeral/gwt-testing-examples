package egger.software.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

@SuppressWarnings("Duplicates")
public class GwtHelloWorld implements EntryPoint {
	private final EchoServiceAsync echoService = GWT.create(EchoService.class);

	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final TextBox messageTextField = new TextBox();
		messageTextField.setText("Message");
		messageTextField.selectAll();
		messageTextField.setFocus(true);
		
		final Label errorLabel = new Label();
		final Label responseLabel = new Label();
		errorLabel.addStyleName("errorLabel");

		VerticalPanel container = new VerticalPanel();
		container.add(messageTextField);
		container.add(sendButton);
		container.add(responseLabel);

		RootPanel.get("container").add(container);


		sendButton.addClickHandler(event -> {
			String textToServer = messageTextField.getText();
			echoService.echo(textToServer, new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					errorLabel.setText("Error: " + caught.getMessage());
				}
				public void onSuccess(String result) {
					responseLabel.setText(result);
				}
			});
		});
	}
}
