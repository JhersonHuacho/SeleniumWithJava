package com.juice.tests;

import com.juice.utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class ReportTest extends BaseTest {

    @Test
    public void getTitle() { // pass
        extentTest = extentReports.createTest("verify Title", "Test verify title");
        extentTest.assignAuthor("Pedro");
        extentTest.assignCategory("Regression");
        extentTest.assignDevice("Win 11 - Edge");

        Assert.assertEquals(driver.getTitle(), "OWASP Juice Shop");
    }

    @Test
    public void verifyLogo() { // fail
        extentTest = extentReports.createTest("verify Logo", "Test verify title");
        extentTest.assignAuthor("Diana");
        extentTest.assignCategory("Regression");
        extentTest.assignDevice("XP");

        boolean logo = driver.findElement(By.className("logo")).isDisplayed();
        assertFalse(logo);
    }

    @Test
    public void skyTest() { // sky
        extentTest = extentReports.createTest("Sky Test", "Test no implement");
        extentTest.assignAuthor("Camila");
        extentTest.assignCategory("Regression");
        extentTest.assignDevice("OS");

        throw new SkipException("pending implement");
    }
}
