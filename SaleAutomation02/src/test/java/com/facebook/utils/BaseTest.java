package com.facebook.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected int TIME_OUT = 10; // segundo
    protected String BASE_URL = "https:/www.facebook.com/";

    @BeforeMethod
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        // asigna un tiempo de espera para ubicar el primer webelement
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }
}
