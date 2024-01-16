package com.softwaretestingboard.pages;

import com.softwaretestingboard.utils.BasePage;
import com.softwaretestingboard.utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;
    By linkSingIn = By.linkText("Sing In");
    By linkAccount = By.linkText("Create an Account");

    public HomePage(WebDriver driver) {
        super(driver);
        visit(Variables.BASE_URL);
    }

    public void goToRegisterLink() {
        click(linkAccount);
    }

    public void goToSingInLink() {
        click(linkSingIn);
    }

    public String verifiyTitle() {
        return null;
    }
}
