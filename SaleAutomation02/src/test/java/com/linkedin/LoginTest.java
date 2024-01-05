package com.linkedin;

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
    protected int TIME_OUT = 10; // segundo

    @BeforeMethod
    public void setup()
    {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        // asigna un tiempo de espera para ubicar el primer webelement
        driver.get("https:/pe.linkedin.com/");
    }

    @Test
    public void doLogin()
    {
        driver.findElement(By.id("session_key")).sendKeys("jhersonhuacho@gmail.com");
        WebElement inputPass = driver.findElement(By.name("session_password"));
        inputPass.clear();
        inputPass.sendKeys("SuperPass");
        // expact relativo => //button[contains(text(),'Sign in')]
        // expact absoluto => /html/body/main/section[1]/div/div/form/div[2]/button
        driver.findElement(By.xpath("//button[contains(text(),'Inicia sesión')]")).submit();


        // assertion
    }

    @AfterMethod
    public void tearDown()
    {
        //driver.quit();
    }
}
