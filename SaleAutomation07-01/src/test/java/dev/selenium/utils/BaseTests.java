package dev.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTests {

    public WebDriver driver;
    int TIME_OUT;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        //driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

