package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RxHomePage extends NativeBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dorothy's account\"]")
    private static WebElement accountHolderName;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='search']")
    private static WebElement searchBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Dorothy Scott.']")
    private static WebElement filterBy;



    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sort by options. Currently sorting by Newest status update']")
    private static WebElement sortBy;


    @AndroidFindBy(xpath = "\t\n" +
            "//android.view.View[contains(@content-desc,\"Good Morning ☀\uFE0F Drink water & take your medications\"]")
    private static WebElement greetingsMsg;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Recent Rx.']")
    private static WebElement filterOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.ScrollView")
    private static List<WebElement> medicinesList;




    public RxHomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public RxHomePage checkUsernameDisplayOnRxHomePage() {
  //    String nameText = accountHolderName.getText();
        if (accountHolderName.isDisplayed()) {
            ExtentLogger.pass("Account holder name displayed on the page");
        } else {
            ExtentLogger.fail("Account holder name not displayed on the page");
        }
       // System.out.println(nameText);
        return this;
    }


    public RxHomePage clickOnSearchBtn() {
        if (searchBtn.isDisplayed() && searchBtn.isEnabled()) {
            ExtentLogger.pass("Search button displayed and enable on the page");
            click(searchBtn, "Search button");
        } else {
            ExtentLogger.fail("Search button is not displayed on the page, or not enable");
        }
        return this;
    }

    public RxHomePage validateGreetingsMsg() {
        if (greetingsMsg.isDisplayed()) {
            ExtentLogger.pass("Greeting message displayed on the page");
        } else {
            ExtentLogger.fail("Greeting message is not display message");
        }
        return this;
    }

    public RxHomePage validateListOfMedicines(){
        for (WebElement ls: medicinesList
             ) {

            System.out.println(ls.getText());

        }
        return this;
    }


    public RxHomePage validateFilterby(){
        if (filterBy.isDisplayed() && filterBy.isEnabled()) {
            ExtentLogger.pass("filterBy button displayed");
        }else{
            ExtentLogger.fail("filterBy button is not displayed or enable");
        }
        return this;
    }

}
