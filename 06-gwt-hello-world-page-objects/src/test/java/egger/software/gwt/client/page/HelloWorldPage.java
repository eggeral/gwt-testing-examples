package egger.software.gwt.client.page;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static egger.software.gwt.client.page.SeleniumTools.waitForAjax;

public class HelloWorldPage {

    private WebDriver driver;

    private HelloWorldPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("GWT Hello World")) {
            throw new IllegalStateException("This is not the hello world page, current page" +
                    "is: " + driver.getCurrentUrl());
        }
    }

    public static HelloWorldPage ensurePageIsShown(WebDriver driver) {

        // Wait for GWT to build the UI.
        WebDriverWait waitMax10Seconds = new WebDriverWait(driver, 10);
        waitMax10Seconds.until((Predicate<WebDriver>) (d) -> d.findElement(By.id("messageTextBox")).isDisplayed());
        return new HelloWorldPage(driver);

    }

    public void echo(String message) {
        WebElement messageElement = driver.findElement(By.id("messageTextBox"));
        messageElement.clear();
        messageElement.sendKeys(message);

        WebElement sendButton = driver.findElement(By.id("sendButton"));
        sendButton.click();

        waitForAjax(driver);

    }

    public String getEchoResult() {
        return driver.findElement(By.id("responseLabel")).getText();
    }

}
