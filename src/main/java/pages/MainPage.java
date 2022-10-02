package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

public class MainPage {
    protected AppiumDriver driver;
    public static final long WAIT = 10;

    public MainPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(80)), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

}
