package com.orange.tests;

import com.orange.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginDPTest extends BaseTest {
    @Test(dataProvider = "dataLogin")
    public void doLogin(String user, String password) {
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("")).submit();

        // assertion
        WebElement lblDash = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        //Assert.assertEquals(lblDahs.getText(), "Dashboard");
        Assert.assertTrue(lblDash.getText().contains("Dashboard"));
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[] { "Admin", "admin123", "" },
                new Object[] { "Admin", "admin321", "Invalid credentials" },
                new Object[] { "Admin2", "admin456", "Invalid credentials" },
        };
    }
}
