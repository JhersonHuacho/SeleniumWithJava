package dev.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxOptionsDosTest {

    WebDriver driver;
    int TIME_OUT = 10;

    @BeforeMethod
    public void setup() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true); // by default en TRUE

        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.cacert.org/");
    }

    @Test
    public void getTitle() {
        Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
        System.out.println("Browser name is: " + capabilities.getBrowserName());
        System.out.println("Browser version is: " + capabilities.getBrowserVersion());
        System.out.println("Platform is: " + capabilities.getPlatformName());

        System.out.println("Platform is: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        //if (driver != null) {
        if (driver != null) {
            driver.quit();
        }
    }

}
