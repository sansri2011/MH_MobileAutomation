package org.magellanhealth.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class PageActionsHelper {


    protected void click(WebElement element, String elementName) {
        element.click();
        System.out.println(elementName + " is clicked successfully");
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

    public static void waitAndClick(By by) {
        //wait strategy
        DriverManager.getDriver().findElement(by).click();
    }

    public static void waitAndClick(By androidBy, By iosBy) {
        //wait strategy
        By byBasedOnMobilePlatform = getByBasedOnMobilePlatform(androidBy, iosBy);
        DriverManager.getDriver().findElement(byBasedOnMobilePlatform).click();
    }

    public static void waitAndType(By by, String value) {
        //wait strategy

        DriverManager.getDriver().findElement(by).sendKeys(new CharSequence[]{value});
    }

    public static void waitAndType(WebElement element, String value) {
        //wait strategy
        try {
            element.clear();
            element.sendKeys(new CharSequence[]{value});
            hideKeyboard();
        } catch (Exception e) {
            e.getMessage();
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


    public static void deleteAndType(WebElement element, String text) {
        try {
//            element.sendKeys(new CharSequence[]{Keys.CONTROL + "a"});
//            element.sendKeys(new CharSequence[]{Keys.DELETE});
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].value='';", element);
            WaitHelpers.waitTime(2L);
//            element.sendKeys(new CharSequence[]{text});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void select(By by, Consumer<Select> consumer) {
        consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
    }

    public static String getAttribute(By by, Function<WebElement, String> attributeFunction) {
        return attributeFunction.apply(DriverManager.getDriver().findElement(by));
    }

    public static boolean isPresent(By by, Predicate<WebElement> elementPredicate) {
        return elementPredicate.test(DriverManager.getDriver().findElement(by));
    }

    private static By getByBasedOnMobilePlatform(By androidBy, By iosBy) {
        return isAndroid() ? androidBy : iosBy;
    }

    private static boolean isAndroid() {
        return DriverManager.getDriver() instanceof AndroidDriver;
    }

    public static void scrollForMobile(By by) {
        String previousPageSource = "";
        while (isElementNotEnabled(by) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = DriverManager.getDriver().getPageSource();
            performScroll();
        }
    }

    public static void scrollForMobile(WebElement element) {
        String previousPageSource = "";
        while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
            previousPageSource = DriverManager.getDriver().getPageSource();
            performScroll();
        }
    }

    private static boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(DriverManager.getDriver().getPageSource());
    }

    private static boolean isElementNotEnabled(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    private static boolean isElementNotEnabled(By by) {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        if (isAndroid()) {
            return elements.isEmpty();
        }
        if (!elements.isEmpty()) {
            return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
        }
        return true;
    }

    private static void performScroll() {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int endX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        performScrollUsingSequence(startX, startY, endX, endY);
    }

    private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequence));
    }

    public static void sendTextUsingJS(String text) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("mobile: performEditorAction", new Object[]{ImmutableMap.of("action", text)});
        ExtentLogger.pass("User entered "+text+" successfully");

    }
    public static void clickByCoordinates(int x, int y, long seconds) {
        new TouchAction((PerformsTouchActions) DriverManager.getDriver())
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
        ExtentLogger.info("tapped by co-ordinates");
    }

    public static void hideKeyboard() {
        AndroidDriver driver;
        driver = (AndroidDriver) DriverManager.getDriver();
        driver.hideKeyboard();

    }
}