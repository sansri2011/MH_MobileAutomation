package org.magellanhealth.Listeners;

import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.Report.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        new ExtentReport().createTest(result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
        ExtentLogger.fail(result.getThrowable().toString());

        //ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        new ExtentReport().initReport();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        new ExtentReport().tearDownReport();

    }
}
