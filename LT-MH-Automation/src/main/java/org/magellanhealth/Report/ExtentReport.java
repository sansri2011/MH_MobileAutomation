package org.magellanhealth.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.HidesKeyboardWithKeyName;
import org.magellanhealth.utils.PropertyUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    public static ExtentReports extent;
    public static File file;

    public void initReport() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            file = new File(System.getProperty("user.dir") + "/index.html");
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setReportName("Automation Report");
            sparkReporter.config().setDocumentTitle("Mobile Automation");
            extent.attachReporter(sparkReporter);
        }
    }

    public void createTest(String testCaseName) {
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentReport(test);
    }


    public void tearDownReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentManager.unload();
            openReportOnFinish();
        }

    }

    private void openReportOnFinish() {
        try {
            if (PropertyUtils.getValue("openReportAutomaticallyOnTestFinish").equals("true")) {
                Desktop.getDesktop().browse(file.toURI());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
