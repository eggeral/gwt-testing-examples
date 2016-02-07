package egger.software.gwt.client.helloworld;

import com.google.gwt.junit.client.GWTTestCase;

public class UiSpec extends GWTTestCase{
    @Override
    public String getModuleName() {
        return "egger.software.gwt.GwtHelloWorldUnitTestExample";
    }

    public void testUpdateResultTextShouldSetTheTextOfTheResultLabel() {
        // given
        Ui testTarget = new Ui();

        // when
        testTarget.updateResultText("unit test message");

        // then
        assertEquals(testTarget.responseLabel.getText(), "unit test message");

    }

    public void testUpdateErrorTextShouldSetTheTextOfTheErrorLabel() {
        // given
        Ui testTarget = new Ui();

        // when
        testTarget.updateErrorText("unit test message");

        // then
        assertEquals(testTarget.errorLabel.getText(), "unit test message");

    }

}
