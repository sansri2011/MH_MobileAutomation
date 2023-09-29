package org.magellanhealth.Report;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.magellanhealth.utils.ScreenshotUtils;

public class ExtentLogger {
    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);

    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());

    }


    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message) {
        // ExtentManager.getExtentTest().info(message);
        ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());
    }
}
