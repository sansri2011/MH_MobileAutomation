package org.magellanhealth.pages;

import io.appium.java_client.android.AndroidDriver;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NativeBasePage {

    protected static void click(WebElement element, String elementName) {
        if (element.isEnabled()) {
            WaitHelpers.waitTime(5);
            element.click();
        } else {
            System.out.println("Button is not present or enable");
        }
        System.out.println(elementName + " clicked successfully");
        ExtentLogger.pass(elementName + " clicked successfully");
    }

    protected void click(By by, String elementName) {
        click((WebElement) DriverManager.getDriver().findElement(by), elementName);
    }

    protected void click(String locatorType, String value, String elementName) {
        if (locatorType.equals("xpath")) {
            click(By.xpath(value), elementName);
        } else if (locatorType.equals("id")) {
            click(By.id(value), elementName);
        }
    }

    public static void enterTextByJS(WebElement element, String text) {
        try {
            element.clear();
            JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
            executor.executeScript("arguments[0].value=arguments[1];", element, text);
        } catch (Exception exception) {
            exception.getMessage();
        }
    }


    protected String getTextByJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String elementText = (String) js.executeScript("return arguments[0].text", element);
        return elementText;
    }


    public static void hideKeyboard() {
        AndroidDriver driver;
        driver = (AndroidDriver) DriverManager.getDriver();
        driver.hideKeyboard();
    }

    protected static void navigateBackward(WebElement validateTextAfterMovingBack, String pageName, Boolean navigateBackTrueFalse) {
        if (navigateBackTrueFalse) {
            DriverManager.getDriver().navigate().back();
        } else {
            WaitHelpers.waitTime(5);
            if (validateTextAfterMovingBack.isDisplayed()) {
                ExtentLogger.pass("User navigated back successfully from " + pageName + "page");
            } else {
                ExtentLogger.pass("User not navigated back successfully from " + pageName + "page");
            }
        }
    }

    public static void validateElement(WebElement elementToValidate, String elementName) {
        if (elementToValidate.isDisplayed() && elementToValidate.isEnabled()) {
            ExtentLogger.pass(elementName + " displayed and enable on the page");
        } else {
            ExtentLogger.fail(elementName + " is not displayed on the page, or not enable");
        }
    }

    public static void validateText(WebElement element, String attributeName, String expectedTextToBeDisplayed) {
        try {
            if (element.isDisplayed()) {
                String elementAttribute = element.getAttribute(attributeName);
                Assert.assertEquals(expectedTextToBeDisplayed, elementAttribute);
                ExtentLogger.pass("Text "+expectedTextToBeDisplayed+ " displayed");
            }else{
                ExtentLogger.fail("Could not validate text, as element not displayed oe enable");
            }
        } catch (Exception e) {
            ExtentLogger.fail("Could not validate text, as element not present on screen");
        }
    }

}
