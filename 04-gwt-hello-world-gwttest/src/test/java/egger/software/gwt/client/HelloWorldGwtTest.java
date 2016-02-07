package egger.software.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import org.junit.Test;

public class HelloWorldGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "egger.software.gwt.GwtHelloWorldGwtTest";
    }

    public void testDisplaysTheEchoReturnedFromTheEchoService() {
        FlowPanel container = new FlowPanel();
        container.getElement().setId("container");
        RootPanel.getBodyElement().appendChild(container.getElement());

        GwtHelloWorldGwtTest helloWorld = GWT.create(GwtHelloWorldGwtTest.class);
        helloWorld.onModuleLoad();

        InputElement.as(Document.get().getElementById("messageTextBox")).setValue("gwt test");
        ButtonElement.as(Document.get().getElementById("sendButton")).click();

        Timer timer = new Timer() {

            @Override
            public void run() {
                // No threads in GWTTestCase so we have to do this in a timer!
                assertEquals(Document.get().getElementById("responseLabel").getInnerText(), "gwt test");
                finishTest();
            }
        };

        timer.schedule(0);
        delayTestFinish(1000);

    }

    public void testEchoService() {
        EchoServiceAsync echoService = GWT.create(EchoService.class);
        echoService.echo("test", new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                fail(caught.getMessage());
                finishTest();
            }

            @Override
            public void onSuccess(String result) {
                assertEquals(result, "test");
                finishTest();
            }
        });
        delayTestFinish(5000);

    }


}
