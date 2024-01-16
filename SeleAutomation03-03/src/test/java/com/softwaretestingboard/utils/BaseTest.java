package com.softwaretestingboard.utils;

import com.softwaretestingboard.pages.HomePage;
import com.softwaretestingboard.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected RegisterPage registerPage;
    protected HomePage homePage;
    protected BasePage basePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        // pasando la instancia de driver creada en la linea 17 al POM
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
