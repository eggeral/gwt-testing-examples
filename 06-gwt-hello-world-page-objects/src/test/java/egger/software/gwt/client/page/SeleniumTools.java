package egger.software.gwt.client.page;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTools {
    public static void waitForAjax(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((Predicate<WebDriver>) (d) -> d.findElement(By.id("requestPending")).getText().equals("false"));
    }
}
