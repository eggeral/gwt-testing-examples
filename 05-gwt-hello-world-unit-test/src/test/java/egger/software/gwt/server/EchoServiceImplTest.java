package egger.software.gwt.server;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EchoServiceImplTest {
    @Test
    public void echoShouldReturnTheGivenMessage() {
        // given
        EchoServiceImpl testTarget = new EchoServiceImpl();

        // when
        String result = testTarget.echo("test message");

        // then
        assertThat(result, is("test message"));
    }
}
