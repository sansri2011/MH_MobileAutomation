package org.magellanhealth.driverManager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

public class AndroidApp {


    String userName = "ssmagellanhealth";
    String accessKey = "4WXUuKjQ5P6IAjuphwzto4OCutrG8AK9Ah3fvulCK3RoE6kxCN";
    public String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
    AppiumDriver driver;

    @Test
    @org.testng.annotations.Parameters(value = {"device", "version", "platform"})
    public void AndroidApp1(String device, String version, String platform) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "MagellanHealth Android script");
            capabilities.setCapability("name", platform + " " + device + " " + version);
            capabilities.setCapability("deviceName", device);
            capabilities.setCapability("platformVersion", version);
            capabilities.setCapability("platformName", platform);
            capabilities.setCapability("isRealMobile", true);
            //AppURL (Create from Wikipedia.apk sample in project)
            capabilities.setCapability("app", "lt://APP10160631101686236562616670"); //Enter your app url
            //  capabilities.setCapability("app", "lt://APP1016033751686852254611196"); //Enter your app url
            capabilities.setCapability("deviceOrientation", "PORTRAIT");
            capabilities.setCapability("console", true);
            capabilities.setCapability("network", false);
            capabilities.setCapability("visual", true);
            capabilities.setCapability("devicelog", true);
            //capabilities.setCapability("geoLocation", "HK");

            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AppiumDriver(new URL(hub), capabilities);

            Thread.sleep(5000);

            WebElement userName = driver.findElement(By.className("android.widget.EditText"));
            System.out.println(userName.getText());
            userName.sendKeys("abcd");





//            MobileElement color = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/color");
//            //Changes color to pink
//            color.click();
//            Thread.sleep(1000);
//            //Back to orginal color
//            color.click();
//
//            MobileElement text = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/Text");
//            //Changes the text to "Proverbial"
//            text.click();
//
//            //toast will be visible
//            MobileElement toast = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/toast");
//            toast.click();
//
//            //notification will be visible
//            MobileElement notification = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/notification");
//            notification.click();
//            Thread.sleep(2000);

//            //Opens the geolocation page
//            MobileElement geo = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/geoLocation");
//            geo.click();
//            Thread.sleep(5000);
//
//            //takes back to home page
//            MobileElement home = (MobileElement) driver.findElementByAccessibilityId("Home");
//            home.click();
//
//            //Takes to speed test page
//            MobileElement speedtest = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/speedTest");
//            speedtest.click();
//            Thread.sleep(5000);
//
//            MobileElement Home = (MobileElement) driver.findElementByAccessibilityId("Home");
//            Home.click();
//
//            //Opens the browser
//            MobileElement browser = (MobileElement) driver.findElementByAccessibilityId("Browser");
//            browser.click();
//
//            MobileElement url = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/url");
//            url.sendKeys("https://www.lambdatest.com");
//
//            MobileElement find = (MobileElement) driver.findElementById("com.lambdatest.proverbial:id/find");
//            find.click();

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                driver.quit();
            } catch (Exception e1) {
                e.printStackTrace();
            }
        }


    }
}
