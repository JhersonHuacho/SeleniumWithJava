package com.softwaretestingboard.tests;

import com.softwaretestingboard.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    /*@Test
    //public void registerNewAccountWithFullInformation() {
      //  driver.findElement(By.linkText("Create an Account")).click();
    //}*/

    @Test
    public void registerNewAccountWithRequiredInformation() {
        String expected_message = "Thank you for registering with Main Website Store.";

        // got to register page
        driver.findElement(By.linkText("Create an Account")).click();

        // fills the form
        driver.findElement(By.id("firstname")).sendKeys("Francisco");
        driver.findElement(By.id("lastname")).sendKeys("Huacho");
        driver.findElement(By.id("email_address")).sendKeys("drojas19890@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sup3rP@ss");
        driver.findElement(By.id("password-confirmation")).sendKeys("Sup3rP@ss");

        //
        driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button/span")).submit();

        // assertion
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div/text()")));

        Assert.assertEquals(msg.getText(), expected_message);
    }
}
