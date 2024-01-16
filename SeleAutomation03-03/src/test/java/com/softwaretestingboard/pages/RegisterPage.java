package com.softwaretestingboard.pages;

import com.softwaretestingboard.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    WebDriver driver;

    /*
     * Web Elements
     * */

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
        super(driver);
        this.driver = driver;
    }
    /*
     * Methods, functions
     * */



    public void fillOutForm() {
        type(firstName,"Francisco");
        type(lastName,"Huacho");
        type(email, "juan2000@gmail.com");
        type(password, "Sup3rP@ss");
        type(passwordConfirmation, "Sup3rP@ss");
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
