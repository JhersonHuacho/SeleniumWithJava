package com.facebook.tests;

import com.facebook.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends BaseTest {

    @Test
    public void registerWithPhoneNumber() {
        //
    }

    @Test
    public void registerWithEmail() {
        driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Francisco");
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Huacho");
        //driver.findElement(By.name("reg_email__")).sendKeys("94949499");
        driver.findElement(By.name("reg_email__")).sendKeys("jhersonhuacho@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("jhersonhuacho@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("Password");

        // Working with selected
        WebElement inputMonth = driver.findElement(By.id("month"));
        Select cbMonth = new Select(inputMonth);
        cbMonth.selectByIndex(0);

        WebElement inputDay = driver.findElement(By.id("day"));
        Select cbDay = new Select(inputDay);
        cbDay.selectByValue("20");

        WebElement inputYear = driver.findElement(By.id("year"));
        Select cbYear = new Select(inputYear);
        cbYear.selectByVisibleText("2000");

        // primera opción: usando xpath relativo
        WebElement gender_content = driver.findElement(By.xpath("//span[@class='_5k_3']"));
        gender_content.findElement(By.xpath("//input[@value=1]")).click();

        // segunda opción: en una sola línea
        // driver.findElement(By.xpath("//span[@class='_5k_3']//input[@value=2]")).click();

        // tercera opción
        //driver.findElement(By.xpath("//label[contains(text(), 'Custom')]")).click();

        // using findElements with tagName
        List<WebElement> labels = gender_content.findElements(By.tagName("label"));

        for (WebElement webElement : labels) {
            System.out.println("the gender is: " + webElement.getText());
        }

        driver.findElement(By.linkText("Learn more")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();


    }
}


























