package dev.selenium.tests;

import dev.selenium.utils.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterDataProviderTest extends BaseTests {

    By inputfname = By.id("firstname");
    By inputlname = By.id("lastname");
    By inputename = By.name("email");
    By inputpass = By.id("password");
    By inputrepass = By.id("password-confirmation");
    By btnRegister = By.xpath("");

    @Test (dataProvider = "dataProviderRegister")
    public void createNewAccount(String firstName, String lastName, String email, String pass, String repass) {
        driver.findElement(inputfname).sendKeys(firstName);
        driver.findElement(inputlname).sendKeys(lastName);
        driver.findElement(inputename).sendKeys(email);
        driver.findElement(inputpass).sendKeys(pass);
        driver.findElement(inputrepass).sendKeys(repass);
        driver.findElement(btnRegister).submit();
    }

    @DataProvider
    public Object[][] dataProviderRegister() {
        return new Object[][] {
                new Object[]{ "Diana", "Rojas", "drojas@gmail.com", "", "" },
                new Object[]{ "Diana", "Rojas", "drojas@gmail.com", "", "" },
        };
    }
}
