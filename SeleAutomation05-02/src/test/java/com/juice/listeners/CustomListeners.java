package com.juice.listeners;

import com.juice.utils.BaseTest;
import com.juice.utils.Log;
import org.testng.*;

public class CustomListeners implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        Log.info("In on " + result.getName() + " Test starting...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("In on " + result.getName() + " Test completed...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("In on " + result.getName() + " Test Failed...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ISuite suite) {
        Log.info("Im onStart " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Log.info("Im onFinish " + suite.getName());
    }
}
