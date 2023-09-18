package org.magellanhealth.driverManager;


import
        io.appium.java_client.AppiumDriver;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

 public  class Driver {
    private Driver() {
    }

    public static void initDriver(Map<String, String> map) throws MalformedURLException {
        if (Objects.isNull(DriverManager.getDriver())) {
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()), map);
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
