package org.magellanhealth.pages;

import io.appium.java_client.android.AndroidDriver;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonPageMethods extends NativeBasePage {

    public static void verifyKeyboardAppears(WebElement element, String name) {
        if (element.isDisplayed()) {
            try {
                click(element, name);
                if (((AndroidDriver) DriverManager.getDriver()).isKeyboardShown()) {
                    ExtentLogger.pass("Keyboard shown");
                } else {
                    Assert.assertFalse(false, "keyboard not shown");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            ExtentLogger.fail("Email filed is not present on screen");
        }
    }
}
