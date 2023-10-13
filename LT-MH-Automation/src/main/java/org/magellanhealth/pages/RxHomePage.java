package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Rx History tab. 1 of 3. Tap to view your deductible tracker and claim history.']")
    private static WebElement RxHistory;


    @AndroidFindBy(xpath ="//android.view.View[@content-desc='My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.']")
    private static WebElement myRx;

    @AndroidFindBy(xpath ="//android.view.View[@content-desc='More tab. 3 of 3. Tap for settings, support and other options.']")
    private static WebElement moreBtn;

    @AndroidFindBy(xpath ="//android.view.View[@content-desc=' There are no prescriptions available yet. They will appear here once we have a prescription on file and under review. You can look up information on any medication using our search tool.']")
    private static WebElement noPrescriptionText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Dorothy Scott.']")
    private static WebElement filterByFamilyMember;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Go to Rx search']")
    private static WebElement goToRxSearch;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sort by options. Currently sorting by Newest status update']")
    private static WebElement sortBy;

    @AndroidFindBy(xpath = "\t\n" + "//android.view.View[contains(@content-desc,\"Good Morning ☀\uFE0F Drink water & take your medications\"]")
    private static WebElement greetingsMsg;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Recent Rx.']")
    private static WebElement filterOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.ScrollView")
    private static List<WebElement> medicinesList;


    public RxHomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public RxHomePage checkUsernameDisplayOnRxHomePage() {
        validateElement(accountHolderName, "Account holder");
        return this;
    }


    public RxHomePage clickOnSearchBtn() {
        click(searchBtn, "search button");
        return this;
    }


    public RxHomePage validateGreetingsMsg() {
        validateElement(greetingsMsg, "Greeting message");
        return this;
    }

    public RxHomePage validateFilterby() {
        validateElement(filterBy, "filter by");
        return this;
    }

    public RxHomePage validateSearchBtn() {
        validateElement(searchBtn, "Search button");
        return this;
    }

    public RxHomePage validateGoToRxSearchBtn() {
    //    System.out.println(noPrescriptionText.getText());
        validateElement(goToRxSearch, "Go to RXSearch button");
        return this;
    }

    public RxHomePage validateRxHistoryBtn() {
        validateElement(RxHistory, "Rx History button");
        return this;
    }

    public RxHomePage validateMyRxBtn() {
        validateElement(myRx, "My Rx button");
        return this;
    }

    public RxHomePage validateMoreBBtn() {
        validateElement(moreBtn, "More button");
        return this;
    }

    public void rxHomeSearchTest() {
        clickOnSearchBtn();
       // enterTextByJS("");

    }


}
