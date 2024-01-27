package dev.selenium.tests;

import dev.selenium.utils.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginDataProviderExcelTest extends BaseTests {

    FileInputStream fileInputStream;
    By inputEmail = By.name("login[username]");
    By inputpass = By.id("pass");
    By btnSingin = By.id("send2");

    @Test(dataProvider = "excelDataProvider")
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
    public Object[][] excelDataProvider() {
        Object[][] arrayData = getDataFromExcel("", "");
    }

    private Object[][] getDataFromExcel(String pathFile, String sheetname) {
        try {
            fileInputStream = new FileInputStream(pathFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
