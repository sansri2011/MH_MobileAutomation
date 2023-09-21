package org.magellanhealth.driverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BSTest {

    public static void main(String[] args) throws MalformedURLException {

        HashMap<String, String> map = new HashMap<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("project", "SB automation");
        caps.setCapability("build", "Android");
        caps.setCapability("name", "BS test");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("app", "bs://b02d9a8f4258ff631b14926b191a98535e32aa9a");
        caps.setCapability("autoGrantPermissions", String.valueOf(true));
        caps.setCapability("autoAcceptAlerts", String.valueOf(true));

       // map.forEach(caps::setCapability);
        AndroidDriver driver = new AndroidDriver(new URL("http://" + "shalinisanthanam_rwNRbd" + ":" + "YjF9vsWmziLfLqHXzJbK" + "@" + "hub-cloud.browserstack.com"+"/wd/hub"), caps);


    }
}
