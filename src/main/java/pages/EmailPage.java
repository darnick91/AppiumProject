package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EmailPage extends MainPage{
    @FindBy(xpath = "//div[@class = 'il d v']")
    WebElement createButton;

    @FindBy(xpath = "//div[contains(text(),'Отправлено')]")
    WebElement sendMessage;

    public EmailPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public MessagePage createMessage() {
        click(createButton);
        return new MessagePage(driver);
    }

    public boolean sendMessageDisplayed()
    {
        return sendMessage.isDisplayed();
    }

}
