package com.softwaretestingboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    protected int TIME_OUT = 10;

    @BeforeMethod
    public void Setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void SignInAccount() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("login[username]")).sendKeys("jhersonhuacho@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("123456789@");

        WebElement inputSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        inputSubmit.findElement(By.xpath("//span[contains(text(),'Sign In')]")).submit();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
