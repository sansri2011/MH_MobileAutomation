package org.magellanhealth.utils;

import org.magellanhealth.driverManager.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelpers {

    public static void waitUntilElementToBeClickable(WebElement element) {
        FluentWait<WebDriver> ClickableWait =
                (new FluentWait<>(DriverManager.getDriver()))
                        .withTimeout(Duration.ofSeconds(50L))
                        .pollingEvery(Duration.ofMillis(500L))
                        .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        ClickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTime(long second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
        }
    }

    public static void wait(WebElement element, int timeInSec) {
        WebDriverWait username = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeInSec));
        username.until(ExpectedConditions.elementToBeClickable(element));

    }
}

