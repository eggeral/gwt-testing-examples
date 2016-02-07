package egger.software.gwt;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelloWorldTest {

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

	@Test
	public void googleCanSearchHelloWorld() {
        driver.navigate().to("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("hello world");
		element.submit();

		// driver.getTitle(...) has no implicit wait! We have to implement the wait on our own.
		// Wait for the page to load, timeout after 10 seconds
		WebDriverWait waitMax10Seconds = new WebDriverWait(driver, 10);
		waitMax10Seconds.until(ExpectedConditions.titleContains("hello world"));

	}
}
