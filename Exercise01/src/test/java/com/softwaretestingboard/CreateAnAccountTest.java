package com.softwaretestingboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAnAccountTest {

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
    public void CreateAnAccount() {
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.name("firstname")).sendKeys("Francisco");
        driver.findElement(By.name("lastname")).sendKeys("Huacho Inga");
        driver.findElement(By.name("email")).sendKeys("jhersonhuacho@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456789@");
        driver.findElement(By.name("password_confirmation")).sendKeys("123456789@");

        WebElement inputSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        inputSubmit.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).submit();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
