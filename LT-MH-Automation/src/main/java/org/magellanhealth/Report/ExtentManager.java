package org.magellanhealth.Report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {


    public ExtentManager() {
    }
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ExtentTest getExtentTest() {
        return test.get();
    }
    public static void setExtentReport(ExtentTest extentTest) {
        test.set(extentTest);
    }
    public static void unload() {
        test.remove();
    }
}


