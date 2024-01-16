package com.softwaretestingboard.utils;

import com.softwaretestingboard.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected RegisterPage registerPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1200, 740));
        driver.get(Variables.BASE_URL);

        // pasando la instancia de driver creada en la linea 17 al POM
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
