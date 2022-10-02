import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SendMail {

    private static final String SITE = "https://gmail.com";
    private static final String APPIUM = "http://localhost:4723/wd/hub";

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator1");
        caps.setCapability("automationName",
                "UiAutomator2");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        caps.setCapability("noReset", true);
        driver = new AppiumDriver(new URL(APPIUM), caps);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void sendEmail() {
        String email = "appium6@gmail.com";
        String password = "!1Appium0)";
        String to = "amazon.test3001@gmail.com";
        String theme = "amazon";
        LoginPage page = new LoginPage(driver);
        boolean isDelivered = page.openPage()
                .logInWithValidCredentials(email, password)
                .createMessage()
                .sendMessageWithValidData(to, theme)
                .sendMessageDisplayed();

        Assert.assertTrue(isDelivered);
    }
}
