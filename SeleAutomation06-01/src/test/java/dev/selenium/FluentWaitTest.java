package dev.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FluentWaitTest {

    WebDriver driver;
    WebDriverWait wait;
    int TIME_OUT = 10;
    int TIME_POLLING = 2;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

    }
    @Test
    public void verifyCalendarIco() {
        // explicit sleep setting
        driver.findElement(By.xpath("")).click();
        
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIME_OUT))
                .pollingEvery(Duration.ofSeconds(TIME_POLLING))
                .ignoring(NoSuchElementException.class);

        //
        WebElement imgLandscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertTrue(imgLandscape.isDisplayed());
    }

    @AfterMethod
    public  void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
