package org.magellanhealth.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaImp implements IDriver {


    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {

        String userName = PropertyUtils.getValue("username");
        String accessKey = PropertyUtils.getValue("accessKey");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        map.put("w3c", String.valueOf(true));
        map.put("build", "MagellanHealth Android script test");
        map.put("deviceName",map.get("deviceName") );//PropertyUtils.getValue("deviceName"));
        map.put(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        map.put(MobileCapabilityType.PLATFORM_NAME, "Android");
        map.put(MobileCapabilityType.PLATFORM_VERSION, "13");
        map.put(MobileCapabilityType.APP, PropertyUtils.getValue("appURL"));
        map.put("isRealMobile", String.valueOf(true));
        map.put("devicelog", String.valueOf(true));
        map.put("console", String.valueOf(true));
        map.put("autoGrantPermissions", String.valueOf(true));
        map.put("autoAcceptAlerts", String.valueOf(true));

        map.forEach(capabilities::setCapability);
        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));

        String hub = "http://" + userName + ":" + accessKey + PropertyUtils.getValue("gridURL");
        return new AndroidDriver(new URL(hub), capabilities);
    }


}
