package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagePage extends MainPage {

    @FindBy(xpath = "//input[@id='composeto']")
    private WebElement to;

    @FindBy(xpath = "//input[@id='cmcsubj']")
    private WebElement theme;

    @FindBy(xpath = "//div[@data-control-type='cmaasend+104']")
    private WebElement sendButton;

    public MessagePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public EmailPage sendMessageWithValidData(String toText, String themeText) {
        sendText(to, toText);
        sendText(theme, themeText);
        click(sendButton);
        return new EmailPage(driver);
    }
}