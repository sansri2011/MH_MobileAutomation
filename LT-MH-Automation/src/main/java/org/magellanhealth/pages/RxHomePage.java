package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static org.magellanhealth.utils.PageActionsHelper.sendTextUsingJS;

public class RxHomePage extends NativeBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dorothy's account\"]")
    private static WebElement accountHolderName;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='search']")
    private static WebElement searchBtn;


    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\n" + "    ")
    private static WebElement enterInSearch;

    //[@class='android.widget.EditText']/[text()='Search for Rx name']

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Dorothy Scott.']")
    private static WebElement filterBy;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Rx History tab. 1 of 3. Tap to view your deductible tracker and claim history.']")
    private static WebElement RxHistory;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc='My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.']")
    private static WebElement myRx;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More tab. 3 of 3. Tap for settings, support and other options.']")
    private static WebElement moreBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=' There are no prescriptions available yet. They will appear here once we have a prescription on file and under review. You can look up information on any medication using our search tool.']")
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
        validateText(accountHolderName, "content-desc", "Dorothy's account");
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
        final String expectedTextToBeDisplayed = "Filter options. Currently filtering by Dorothy Scott.";
        validateText(filterBy, "content-desc", expectedTextToBeDisplayed);
        return this;
    }

    public RxHomePage validateSearchBtn() {
        validateElement(searchBtn, "Search button");
        validateText(searchBtn, "content-desc", "search");
        return this;
    }

    public RxHomePage validateGoToRxSearchBtn() {
        validateElement(goToRxSearch, "Go to RXSearch button");
        validateText(goToRxSearch, "content-desc", "Go to Rx search");
        return this;
    }

    public RxHomePage validateRxHistoryBtn() {
        validateElement(RxHistory, "Rx History button");
        final String expectedTextToBeDisplayed = "Rx History tab. 1 of 3. Tap to view your deductible tracker and claim history.";
        validateText(RxHistory, "content-desc", expectedTextToBeDisplayed);
        return this;
    }

    public RxHomePage validateMyRxBtn() {
        validateElement(myRx, "My Rx button");
        validateText(myRx,"content-desc","My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.");
        return this;
    }

    public RxHomePage validateMoreBBtn() {
        validateElement(moreBtn, "More button");
        final String expectedTextToBeDisplayed = "More tab. 3 of 3. Tap for settings, support and other options.";
        validateText(moreBtn,"content-desc", expectedTextToBeDisplayed);
        return this;
    }

    public void rxHomeSearchTest() {
        clickOnSearchBtn();
        System.out.println(((SupportsContextSwitching) DriverManager.getDriver()).getContextHandles());
        click(enterInSearch, "search field");
        Set<String> contextHandles = ((SupportsContextSwitching) DriverManager.getDriver()).getContextHandles();
        for (String c : contextHandles) {
            System.out.println(c);
        }
        sendTextUsingJS("Tablet name");
        WaitHelpers.waitTime(2000);

    }


}
