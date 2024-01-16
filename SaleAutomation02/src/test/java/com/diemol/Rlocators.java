package com.diemol;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Rlocators {

    WebDriver driver;
    int TIME_OUT = 10;

    @BeforeTest
    public  void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
    }

    @Test
    public void relativeLocator() {
        WebElement element = driver.findElement(with(By.tagName("li"))
                .toLeftOf(By.id("berlin"))
                .below(By.id("warsaw")));

        System.out.println(element.getAttribute("id"));

        Assert.assertEquals("london", element.getAttribute("id"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
