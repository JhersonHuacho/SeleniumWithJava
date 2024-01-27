package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ImplicitWaitTest {

    ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    }
    @Test
    public void verifyCalendarIco() {
        WebElement imgCalendar = driver.findElement(By.id("calendar"));
        assertTrue(imgCalendar.getAttribute("src").toString().contains("calendar"));
        String paths = imgCalendar.getAttribute("src");
    }

    @AfterMethod
    public  void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
