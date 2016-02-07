package egger.software.gwt.client.helloworld;

import com.google.gwt.user.client.ui.*;

public class Ui {

    final Button sendButton = new Button("Send");
    final TextBox messageTextField = new TextBox();
    final Label errorLabel = new Label();
    final Label responseLabel = new Label();


    public void layout() {
        sendButton.getElement().setId("sendButton");

        messageTextField.setText("Message");
        messageTextField.selectAll();
        messageTextField.setFocus(true);
        messageTextField.getElement().setId("messageTextBox");

        errorLabel.getElement().setId("errorLabel");
        errorLabel.addStyleName("errorLabel");

        responseLabel.getElement().setId("responseLabel");

        VerticalPanel container = new VerticalPanel();
        container.add(messageTextField);
        container.add(sendButton);
        container.add(responseLabel);

        RootPanel.get("container").add(container);
    }

    public void connectEvents(Action action) {
        sendButton.addClickHandler(event -> {
            action.echoMessage(messageTextField.getText());
        });
    }

    public void updateErrorText(String message) {
        errorLabel.setText(message);
    }

    public void updateResultText(String message) {
        responseLabel.setText(message);
    }
}
