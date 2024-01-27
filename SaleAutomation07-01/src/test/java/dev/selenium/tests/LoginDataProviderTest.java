package dev.selenium.tests;

import dev.selenium.utils.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginDataProviderTest extends BaseTests {

    By inputEmail = By.name("login[username]");
    By inputpass = By.id("pass");
    By btnSingin = By.id("send2");

    @Test(dataProvider = "dp")
    public void doLogin(String user, String pass) {
        driver.findElement(inputEmail).sendKeys(user);
        driver.findElement(inputpass).sendKeys(pass);
        driver.findElement(btnSingin).submit();

        //
        WebElement header = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath("/dfd")));
        assertEquals(header.getText(), "Account Information");
        System.out.println("Method -> doLoginAfterRegister");
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                new Object[]{ "drojas@gmail.com", "121212" },
                new Object[]{ "amaque@gmail.com", "989898" }
        };
    }
}
