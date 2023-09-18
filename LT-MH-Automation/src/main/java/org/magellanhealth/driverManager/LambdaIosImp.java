package org.magellanhealth.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.magellanhealth.Constant.FrameworkConstant;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class LambdaIosImp implements IDriver {

    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {

        String userName = PropertyUtils.getValue("username");
        String accessKey = PropertyUtils.getValue("accessKey");


        DesiredCapabilities capabilities = new DesiredCapabilities();

        map.put("w3c", String.valueOf(true));
        map.put("build", "MagellanHealth iOS script test");
        map.put("name", "MagellanHealth iOS");
        map.put(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Plus");
        map.put("platformVersion", "16");
        map.put(MobileCapabilityType.PLATFORM_NAME, "ios");
        map.put("isRealMobile", String.valueOf(true));
        map.put("app", PropertyUtils.getValue("iOSApp")); //Enter your app url
        map.put("autoGrantPermissions", String.valueOf(true));
        map.put("autoAcceptAlerts", String.valueOf(true));

        map.forEach(capabilities::setCapability);
        capabilities.setCapability("lt:options", map);
        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));

        String hub = "http://" + userName + ":" + accessKey + PropertyUtils.getValue("gridURL");

        return new IOSDriver(new URL(hub), capabilities);
    }
}
