package dev.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomeTest {

    WebDriver driver; // creando un objeto de tipo WebDriver
    String expected_title = "Selenium";

    @BeforeMethod
    public void setup() {
        System.out.println("antes del test");

        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("beta");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
    }
    @Test (priority = 2)
    public void verifyLogo() {
        System.out.println("durante el test 2");
        WebElement imgLogo = driver.findElement(By.id("Layer_1"));
        Assert.assertTrue(imgLogo.isDisplayed()); // verificación del logo
    }

    @Test (priority = 1, description = "Este test permite verificar el titulo de página a testear")
    public void verifyTitle() {
        System.out.println("durante el test 1");
        Assert.assertEquals(driver.getTitle(), expected_title);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("después del test");
        //driver.close(); // cierra el navegador y no termina la sesión creada
        driver.quit(); // termina la sessión del driver creado
    }
}
