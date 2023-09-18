package org.magellanhealth.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class testScript {


    @Test
    public void getDriver() throws MalformedURLException, InterruptedException {

        String userName =PropertyUtils.getValue("username");
        String accessKey =PropertyUtils.getValue("accessKey");
        String appURL = PropertyUtils.getValue("appURL");

        String gridURL =PropertyUtils.getValue("gridURL");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("w3c", true);
        ltOptions.put("build", "MagellanHealth iOS script");
        ltOptions.put("name", "my test");
        ltOptions.put(MobileCapabilityType.DEVICE_NAME, "Galaxy S21 Ultra 5G");
        ltOptions.put("platformVersion", "11");
        ltOptions.put(MobileCapabilityType.PLATFORM_NAME, "ios");
        ltOptions.put("isRealMobile", true);
        ltOptions.put("app", PropertyUtils.getValue("appURL"));

        ltOptions.forEach(capabilities::setCapability);

        capabilities.setCapability("lt:options", ltOptions);
        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));

        String hub = "https://" + userName + ":" + accessKey + gridURL;
        AndroidDriver driver = new AndroidDriver(new URL("http://ssmagellanhealth:4WXUuKjQ5P6IAjuphwzto4OCutrG8AK9Ah3fvulCK3RoE6kxCN@mobile-hub.lambdatest.com/wd/hub"), capabilities);

        //http://ssmagellanhealth:4WXUuKjQ5P6IAjuphwzto4OCutrG8AK9Ah3fvulCK3RoE6kxCN@mobile-hub.lambdatest.com/wd/hub
        Thread.sleep(5000);


        WebDriverWait username = new WebDriverWait(driver, Duration.ofSeconds(30));
        username.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'android.widget.EditText')][1]")));
        driver.findElement(By.xpath("//*[contains(@class,'android.widget.EditText')][1]")).click();

        driver.executeScript("mobile: performEditorAction", new Object[]{ImmutableMap.of("action", "shivbvjcl@gmail.com")});

        driver.hideKeyboard();

        WebDriverWait password = new WebDriverWait(driver, Duration.ofSeconds(30));
        password.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'android.widget.EditText')][2]")));
        driver.findElement(By.xpath("//*[contains(@class,'android.widget.EditText')][2]")).click();
        driver.executeScript("mobile: performEditorAction", new Object[]{ImmutableMap.of("action", "Testing123!")});

        driver.hideKeyboard();

        WebDriverWait signin = new WebDriverWait(driver, Duration.ofSeconds(30));
        signin.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Sign in']")));
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Sign in']")).click();
        Thread.sleep(5000L);
        WebDriverWait next = new WebDriverWait(driver, Duration.ofSeconds(30));
        next.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Next']")));
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Next']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Next']")).click();
        Thread.sleep(2000L);
        WebDriverWait started = new WebDriverWait(driver, Duration.ofSeconds(30));
        started.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Get started']")));
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Get started']")).click();
        Thread.sleep(5000L);



    }


}
