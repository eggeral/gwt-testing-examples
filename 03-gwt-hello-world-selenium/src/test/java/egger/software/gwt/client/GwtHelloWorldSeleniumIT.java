package egger.software.gwt.client;

import com.google.common.base.Predicate;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class GwtHelloWorldSeleniumIT {

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

        driver.navigate().to("http://127.0.0.1:8888/gwt_hello_world_selenium.html");

        // Wait for GWT to build the UI.
        WebDriverWait waitMax10Seconds = new WebDriverWait(driver, 10);
        waitMax10Seconds.until((Predicate<WebDriver>) (d) -> d.findElement(By.id("messageTextBox")).isDisplayed());

        WebElement messageElement = driver.findElement(By.id("messageTextBox"));
        messageElement.clear();
        messageElement.sendKeys("junit");

        WebElement sendButton = driver.findElement(By.id("sendButton"));
        sendButton.click();

        WebDriverWait waitMax1Second = new WebDriverWait(driver, 1);
        waitMax1Second.until((Predicate<WebDriver>) (d) -> d.findElement(By.id("responseLabel")).getText().equals("junit"));

    }
}
