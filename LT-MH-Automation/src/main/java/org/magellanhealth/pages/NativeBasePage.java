package org.magellanhealth.pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;

public class NativeBasePage {

    protected static void click(WebElement element, String elementName) {
        //   scrollToElement(element);
        WaitHelpers.waitUntilElementToBeClickable(element);
        if (element.isEnabled()) {

            // WaitHelpers.waitTime(5);
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


    public static String getText(WebElement element) {
        String attributeText = "";
        WaitHelpers.waitUntilElementToBeClickable(element);
        try {
            if (element.isDisplayed()) {
                attributeText = element.getAttribute("content-desc");
            }
        } catch (Exception e) {
            e.getMessage();
            ExtentLogger.fail("Element not displayed");

        }

        return attributeText;
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

    public static void clickByJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", element);
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
        scrollToElement(elementToValidate);
        if (elementToValidate.isDisplayed() && elementToValidate.isEnabled()) {
            ExtentLogger.pass(elementName + " displayed and enable on the page");
        } else {
            ExtentLogger.fail(elementName + " is not displayed on the page, or not enable");
        }
    }

    public static void validateText(WebElement element, String attributeName, String expectedTextToBeDisplayed) {
        try {
            scrollToElement(element);
            if (element.isDisplayed()) {
                String elementAttribute = element.getAttribute(attributeName);
                Assert.assertEquals(expectedTextToBeDisplayed, elementAttribute);
                ExtentLogger.pass("Text " + expectedTextToBeDisplayed + " displayed");
            } else {
                ExtentLogger.fail("Could not validate text, as element not displayed oe enable");
            }
        } catch (Exception e) {
            ExtentLogger.fail("Could not validate text, as element not present on screen");
        }
    }

    public static void scrollToElement(WebElement elementLocator) {
        int maxScrolls = 5;  // Adjust this based on your needs
        int scrolls = 0;

        while (scrolls < maxScrolls) {
            try {
                //  WebElement element = DriverManager.getDriver().findElement(elementLocator);
                if (elementLocator.isDisplayed()) {
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Element not found, perform a scroll
                int startX = DriverManager.getDriver().manage().window().getSize().getWidth() / 2;
                int startY = DriverManager.getDriver().manage().window().getSize().getHeight() * 3 / 4;
                int endY = DriverManager.getDriver().manage().window().getSize().getHeight() / 4;

                TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
                action.press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();
                scrolls++;
            }
        }
    }

    public static void tapElement(int x, int y) {
        AndroidDriver driver;
        driver = (AndroidDriver) DriverManager.getDriver();
        TouchAction<?> action = new TouchAction<>(driver);

    }

    public static void tapElement(WebElement element) {

        try {
            AndroidDriver androidDriver = (AndroidDriver) DriverManager.getDriver();
            Point source = element.getLocation();
            PointerInput finger = new PointerInput(PointerInput.Kind.MOUSE, "finger");
            Sequence sequence = new Sequence(finger, 1);
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, Duration.ofMillis(600)));
            sequence.addAction(finger.createPointerMove(Duration.ofMillis(600),
                    PointerInput.Origin.viewport(), source.x + 400, source.y));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
            androidDriver.perform(Collections.singletonList(sequence));
        } catch (Exception ex) {
            ExtentLogger.fail("Exception in tapElement(): " + ex);
        }
    }


    public static void doubleTap(WebElement element) {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) DriverManager.getDriver());

        // Perform the double tap
        touchAction.tap(ElementOption.element(element)).perform();
        //touchAction.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).perform(); // Wait for a short time
        touchAction.tap(ElementOption.element(element)).perform();
    }
}
