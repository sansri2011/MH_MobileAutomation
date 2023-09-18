package org.magellanhealth.driverManager;

import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public class DriverFactory {

    private DriverFactory() {
    }


    public static WebDriver get(Modes mode, Map<String, String> map) throws MalformedURLException {
        WebDriver driver = null;

        if (mode == Modes.LAMBDA) {
            driver = getDriver(map);
        } else if (mode == Modes.LOCAL) {
            driver = new LocalDriverImp().getDriver(map);
        } else if (mode == Modes.BS) {
            driver = new BrowserStackImp().getDriver(map);
        } else {
            throw new RuntimeException("No valid cloud provide name mentioned in property file");

        }
        return driver;
    }

    private static WebDriver getDriver(Map<String, String> map) throws MalformedURLException {
        WebDriver driver;
        if (PropertyUtils.getValue("platform").equalsIgnoreCase("ios"))
            driver = new LambdaIosImp().getDriver(map);
        else {
            driver = new LambdaImp().getDriver(map);
        }
        return driver;
    }

}
