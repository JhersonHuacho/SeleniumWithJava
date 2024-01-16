package com.softwaretestingboard.tests;

import com.github.javafaker.Faker;
import com.softwaretestingboard.utils.BaseTest;
import com.softwaretestingboard.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class RegisterTest extends BaseTest {
    //@Test
    public void registerNewAccountWithFullInformation() {
        driver.findElement(By.linkText("Create an Account")).click();
    }

    Faker faker = new Faker(new Locale("en-US"));

    @Test
    public void registerNewAccountWithRequiredInformation() {
        String expected_message = "Thank you for registering with Main Website Store.";
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8,10,true, true);

        // got to register page
        homePage.goToRegisterLink();

        // fills the form
        registerPage.fillOutForm();

        // fills the form with fakeData
        registerPage.fillOutFormWithFakeData(
                faker.name().firstName(),
                faker.name().lastName(),
                email,
                password);

        // submit informatio
        registerPage.submitData();

        // assertion
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/text()")));
        System.out.println("Email is: " + email + " Password is: " + password);
        Assert.assertEquals(msg.getText(), expected_message);
    }
}
