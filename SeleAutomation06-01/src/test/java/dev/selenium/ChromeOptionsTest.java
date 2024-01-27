package dev.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeOptionsTest {

    WebDriver driver;
    int TIME_OUT = 10;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("120");
        chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
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
        if (driver != null) {
            driver.quit();
        }
    }

}
