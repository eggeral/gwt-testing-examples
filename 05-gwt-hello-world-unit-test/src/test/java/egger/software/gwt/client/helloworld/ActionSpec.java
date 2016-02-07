package egger.software.gwt.client.helloworld;

import egger.software.gwt.client.EchoServiceAsync;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActionSpec {

    @Test
    public void echoMessageShouldUpdateTheResultTextWithTheMessageReturnedFromTheEchoService() {
        // given
        Ui uiMock = mock(Ui.class);
        EchoServiceAsync echoServiceMock = new EchoServiceAsyncFake(false);

        Action testTarget = new Action(uiMock, echoServiceMock);

        // when
        testTarget.echoMessage("unit test message");

        // then
        verify(uiMock).updateResultText("unit test message");
    }

    @Test
    public void echoMessageShouldUpdateTheErrorTextWithTheMessageOfTheExceptionReturnedFromTheEchoService() {
        // given
        Ui uiMock = mock(Ui.class);
        EchoServiceAsync echoServiceMock = new EchoServiceAsyncFake(true);

        Action testTarget = new Action(uiMock, echoServiceMock);

        // when
        testTarget.echoMessage("unit test message");

        // then
        verify(uiMock).updateErrorText("Error: unit test message");
    }

}
