package org.magellanhealth.driverManager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class testScript{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        getDriver();
    }


    public  static void getDriver() throws MalformedURLException, InterruptedException {

        String userName = "ssmagellanhealth"; // PropertyUtils.getValue("username");
        String accessKey = "4WXUuKjQ5P6IAjuphwzto4OCutrG8AK9Ah3fvulCK3RoE6kxCN";//PropertyUtils.getValue("accessKey");

        String gridURL = "@mobile-hub.lambdatest.com/wd/hub";//PropertyUtils.getValue("gridURL");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        HashMap<String, String> ltOptions = new HashMap<String, String>();
//        map.put("w3c", String.valueOf(true));
//        map.put("build", "MagellanHealth Android script");
//        map.put("name", "my test");
//        map.put("deviceName", "Galaxy S21 Ultra 5G");
//        map.put("platformVersion", "11");
//        map.put("platformName", "Android");
//        map.put("isRealMobile", String.valueOf(true));
//        map.put("app", "lt://APP10160531401677087270178180"); //Enter your app url
////        capabilities.setCapability("deviceOrientation", "PORTRAIT");
////        capabilities.setCapability("console", true);
////        capabilities.setCapability("network", false);
////        capabilities.setCapability("visual", true);
////        capabilities.setCapability("devicelog", true);
//        capabilities.setCapability("lt:options", ltOptions);
//
//
//
//        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "MagellanHealth iOS script");
        capabilities.setCapability("name", "IOS test");
        capabilities.setCapability("deviceName", "iPhone 14 Pro");
        capabilities.setCapability("platformVersion", 16);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("isRealMobile", true);
        capabilities.setCapability("app", "lt://APP1016033751689967628948981"); //Enter your app url
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", false);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);
        //capabilities.setCapability("geoLocation", "HK");

        String hub = "https://" + userName + ":" + accessKey + gridURL;
        AppiumDriver driver = new AppiumDriver(new URL(hub), capabilities);


        Thread.sleep(5000);
        //String hub = "https://" + userName + ":" + accessKey + gridURL;
        //  AndroidDriver driver = new AndroidDriver(new URL("https://ssmagellanhealth:4WXUuKjQ5P6IAjuphwzto4OCutrG8AK9Ah3fvulCK3RoE6kxCN@mobile-hub.lambdatest.com/wd/hub"), capabilities);
        //  return driver;
    }
}