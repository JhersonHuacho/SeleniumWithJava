package dev.selenium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageLoadStrategyTest {
    WebDriver driver;
    PageLoadStrategy pageLoadStrategy;
    Capabilities capabilities;
    int TIME_OUT = 10;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();

        pageLoadStrategy = PageLoadStrategy.NORMAL;
        capabilities = new DesiredCapabilities();
        chromeOptions.setPageLoadStrategy(pageLoadStrategy);

        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void getTitle() {
        long initMillSec = System.currentTimeMillis();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        String browserName = capabilities.getBrowserName();
        Duration elapse = Duration.ofMillis(System.currentTimeMillis() - initMillSec);

        System.out.println("Platform is: " + driver.getTitle());
        System.out.println("This page took: " + elapse.toMillis() + " with pageLoadStrategy" + pageLoadStrategy.toString() + " on " + browserName + " with version " + capabilities.getBrowserVersion());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
