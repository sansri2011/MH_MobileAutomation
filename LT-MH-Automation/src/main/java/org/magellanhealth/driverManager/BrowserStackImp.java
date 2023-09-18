package org.magellanhealth.driverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("app", "bs://c51aa6e3018582140a34be9600466d8115cd8900");
        map.put("autoGrantPermissions", String.valueOf(true));
        map.put("autoAcceptAlerts", String.valueOf(true));

        map.forEach(caps::setCapability);
        return new AndroidDriver(new URL("http://"+"shalinisanthanam_rwNRbd"+":"+"YjF9vsWmziLfLqHXzJbK"+"@"+"hub-cloud.browserstack.com/wd/hub"), caps);
    }
}
