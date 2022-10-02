package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends MainPage {
    private static final String SITE = "https://gmail.com";

    @FindBy(xpath = "//input[@type = 'email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoginPage openPage() {
        driver.get(SITE);
        return this;
    }

    public EmailPage logInWithValidCredentials(String emailText, String passwordText) {
        sendText(email, emailText + "\n");
        sendText(password, passwordText + "\n");
        return new EmailPage(driver);
    }

}
