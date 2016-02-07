package egger.software.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtHelloWorldGwtTest implements EntryPoint {
	private final EchoServiceAsync echoService = GWT.create(EchoService.class);

	@SuppressWarnings("Duplicates")
	public void onModuleLoad() {

		final Button sendButton = new Button("Send");
		sendButton.getElement().setId("sendButton");
		
		final TextBox messageTextField = new TextBox();
		messageTextField.setText("Message");
		messageTextField.selectAll();
		messageTextField.setFocus(true);
		messageTextField.getElement().setId("messageTextBox");
		
		final Label errorLabel = new Label();
		errorLabel.getElement().setId("errorLabel");
		errorLabel.addStyleName("errorLabel");

		final Label responseLabel = new Label();
		responseLabel.getElement().setId("responseLabel");
		
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
