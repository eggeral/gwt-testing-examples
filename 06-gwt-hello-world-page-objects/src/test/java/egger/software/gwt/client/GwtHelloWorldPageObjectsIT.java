package egger.software.gwt.client;

import com.google.common.base.Predicate;
import egger.software.gwt.client.page.HelloWorldPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GwtHelloWorldPageObjectsIT {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // This assumes that the server was started manually!
    @Test
    public void displaysTheEchoReturnedFromTheEchoService() {
        // given
        driver.navigate().to("http://127.0.0.1:8888/gwt_hello_world_page_objects.html");
        HelloWorldPage helloWorldPage = HelloWorldPage.ensurePageIsShown(driver);

        // when
        helloWorldPage.echo("junit");

        // then
        assertThat(helloWorldPage.getEchoResult(), is("junit"));
    }
}
