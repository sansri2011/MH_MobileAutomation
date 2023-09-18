package org.magellanhealth.driverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.magellanhealth.Constant.FrameworkConstant;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LocalDriverImp implements IDriver {

    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {
        //  File appLocation = new File(FrameworkConstant.getApkFilePath());

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName", "Android");
        options.setCapability("app", FrameworkConstant.getApkFilePath());
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel6");
        options.setCapability("autoAcceptAlerts", true);

        // options.setCapability("autoGrantPermission": true);
        return new AndroidDriver(new URL("http://127.0.1.1:4723/"), options);
    }

}