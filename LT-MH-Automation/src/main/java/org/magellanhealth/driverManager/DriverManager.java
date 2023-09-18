package org.magellanhealth.driverManager;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private DriverManager() {
    }

//Making the driver as threaLocal -> means thread safe
    private static  ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void unload(){
        threadLocalDriver.remove();
    }

}
