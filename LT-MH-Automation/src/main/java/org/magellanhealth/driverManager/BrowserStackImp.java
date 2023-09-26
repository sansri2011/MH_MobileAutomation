package org.magellanhealth.driverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImp implements IDriver {

    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        map.put("project", "SB automation");
        map.put("build", "Android");
        map.put("name", "BS test");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S22 Ultra");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("app", PropertyUtils.getValue("BS_App"));
        map.put("autoGrantPermissions", String.valueOf(true));
        map.put("autoAcceptAlerts", String.valueOf(true));

        map.forEach(caps::setCapability);
        caps.asMap().forEach((k, v) -> System.out.println(k + ":" + v));
        return new AndroidDriver(new URL("http://"+"shalinisanthanam_rwNRbd"+":"+"YjF9vsWmziLfLqHXzJbK"+"@"+"hub-cloud.browserstack.com/wd/hub"), caps);
    }
}
