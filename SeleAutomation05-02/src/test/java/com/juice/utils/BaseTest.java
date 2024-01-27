package com.juice.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    public WebDriver driver;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    String reportName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    @BeforeTest // creating to report spark.html
    public void setupReport() {
        extentSparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/reports/"+reportName+"report1.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            //
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case Failed", ExtentColor.RED));
            // root cause
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - possible root cause", ExtentColor.YELLOW));
            // take screen
            String ScreenPath = "create your method for take screen";
            extentTest.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(ScreenPath).build());
        }

        if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test case skipped", ExtentColor.ORANGE));
        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case passed", ExtentColor.GREEN));
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void makeReport() {
        extentReports.flush();
    }
}
