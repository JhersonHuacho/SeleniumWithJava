package com.softwaretestingboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    /*
    * Web Elements
    * */
    By linkAccount = By.linkText("Create an Account");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By passwordConfirmation = By.id("password-confirmation");
    By btnRegister = By.xpath("//*[@id='form-validate']/div/div[1]/button/span");

    /*
    * Constructor
    * */
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    /*
     * Methods, functions
     * */

    public void goToRegisterLink() {
        driver.findElement(linkAccount).click();
    }

    public void fillOutForm() {
        driver.findElement(firstName).sendKeys("Francisco");
        driver.findElement(lastName).sendKeys("Huacho");
        driver.findElement(email).sendKeys("juan2000@gmail.com");
        driver.findElement(password).sendKeys("Sup3rP@ss");
        driver.findElement(passwordConfirmation).sendKeys("Sup3rP@ss");
    }

    public void fillOutFormWithFakeData(
            String sfname, String slname, String semail, String sPass) {
        driver.findElement(firstName).sendKeys(sfname);
        driver.findElement(lastName).sendKeys(slname);
        driver.findElement(email).sendKeys(semail);
        driver.findElement(password).sendKeys(sPass);
        driver.findElement(passwordConfirmation).sendKeys(sPass);
    }

    public void submitData() {
        driver.findElement(btnRegister).submit();
    }
}
