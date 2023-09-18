package org.magellanhealth.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.PageActionsHelper;
import org.magellanhealth.utils.PropertyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends PageActionsHelper {
AppiumDriver driver;

    @AndroidFindBy(className = "android.widget.EditText")
    private List<WebElement> editList;

    @AndroidFindBy(xpath = "//android.widget.EditText[1]")//*[@text='Enter your email ']")
    private WebElement email;


//    @iOSBy(xpath = "//XCUIElementTypeTextField[@name='Enter your email ']")
 // @iOSBy(id = "Enter your email")
   // private WebElement iosEmail;


  //  @iOSBy(xpath = "//XCUIElementTypeTextField[@name='Enter your password ']")
   // private WebElement iosPasword;


    @AndroidFindBy(xpath = "//android.widget.EditText[2]")//*[@text='Enter your password ']")
    private WebElement pwd;


    private static final By uname = AppiumBy.xpath("//*[@text='Enter your email ']");
    private static final By pawd = AppiumBy.xpath("//*[@text='Enter your password ']");
    private static final By signIn = AppiumBy.accessibilityId("Sign In");


    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void loginPage() throws InterruptedException {

      //  Thread.sleep(10000);
           //click(email,"username");
        Thread.sleep(10000);
        email.sendKeys(PropertyUtils.getValue("appUsername"));
      // driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Enter your email ']")).sendKeys("fgffhf");


//        String replaced = email.getText().replaceAll("['Enter your email ']", "");
//        String replacedUsername = replaced.replace(",","").replaceAll("\"","").trim();
//        email.sendKeys(replacedUsername);
        //hideKeyboard();


        //     click(iosPasword,"password");
        Thread.sleep(500);
        pwd.sendKeys(PropertyUtils.getValue("appPassword"));
//        String replacedPwd = pwd.getText().replaceAll("['Enter your password ']", "").replace(",","").replaceAll("\"","").trim();
//          pwd.sendKeys(replacedPwd);
//   //     hideKeyboard();
        Thread.sleep(500);
//
//
//        Thread.sleep(500);
        click(signIn, "sign in");
        Thread.sleep(50000);
    }


}
