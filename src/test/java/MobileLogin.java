import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileLogin {

    private AndroidDriver driver;

    @Before
    public void setCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "pixel");
        capabilities.setCapability("appium:platformName", "android");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:appPackage", "kz.bcc.starbanking.stage");
        capabilities.setCapability("appium:appActivity", "kz.bcc.starbanking.ui.screens.splash.SplashActivity");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @Test
    public void sampleTest() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("kz.bcc.starbanking.stage:id/fragment_container")));
        WebElement bills = driver.findElement(By.id("kz.bcc.starbanking.stage:id/navigation_bar_item_large_label_view"));
        String results = bills.getText();
        Assert.assertEquals("Should be bills", "Счета", results);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

