package org.magellanhealth.pages;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.magellanhealth.utils.PageActionsHelper.sendTextUsingJS;

public class RxHomePage extends NativeBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dorothy's account\"]")
    private static WebElement accountHolderName;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='search']")
    private WebElement searchBtn;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    private  WebElement enterInSearch;
    // @AndroidFindBy(xpath = "//*[@content-desc='Amoxicillin Trihydrate']")
    @AndroidFindBy(xpath = "//*[@content-desc='Amoxicillin']")
    private WebElement drugName;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Show details\"]")
    private WebElement showDetailsBtn;


    @AndroidFindBy(xpath = "//*[@content-desc='Near my location ']")
    private WebElement nearMyLocation;

    @AndroidFindBy(xpath = "//*[@class='android.widget.HorizontalScrollView']/*[@class='android.widget.Button']")
    private List<WebElement> pharmaciesList;
    @AndroidFindBy(xpath = "//*[@content-desc=\"Show pharmacy options Near my home\"]")
    private WebElement showLocation;

    //*[@content-desc='Show pharmacy options Near my home']
    @AndroidFindBy(xpath = "//*[@content-desc=\"Customize your 'Amoxicillin Trihydrate' search\"]")
    private WebElement rxFilterTitle;


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")
    private List<WebElement> medicineList;
    //[@class='android.widget.EditText']/[text()='Search for Rx name']

    //android.view.View[@content-desc="Filter by family member The names listed below are family members that shared their prescription data with you"]/android.view.View/android.view.View

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Dorothy Scott.']")
    private  WebElement filterByFamilyMember;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Dorothy Scott.']")
    private WebElement filterBy;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Hunter Scott ']")
    private WebElement familyMemberHunterScott;


    @AndroidFindBy(xpath = "//*[@class='android.view.View']/*[@class='android.widget.Button']")
    private List<WebElement> familyMemberList;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ScrollView']/*[@class='android.widget.Button']")
    private static List<WebElement> myRxHomeDrugList;

    @AndroidFindBy(xpath = "//*[@content-desc='Sort by options. Currently sorting by Newest status update']")
    private WebElement sortByBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Close Search']")
    private WebElement searchCloseBtn;


//android.view.View[@content-desc="Filter by family member The names listed below are family members that shared their prescription data with you"]/android.view.View/android.view.View


    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Rx History tab. 1 of 3. Tap to view your deductible tracker and claim history.']")
    private WebElement RxHistory;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc='My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.']")
    private WebElement myRx;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More tab. 3 of 3. Tap for settings, support and other options.']")
    private WebElement moreBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=' There are no prescriptions available yet. They will appear here once we have a prescription on file and under review. You can look up information on any medication using our search tool.']")
    private WebElement noPrescriptionText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Go to Rx search']")
    private WebElement goToRxSearch;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sort by options. Currently sorting by Newest status update']")
    private WebElement sortBy;

    @AndroidFindBy(xpath = "//*[@class='android.view.View' and ./*[@content-desc='Alphabetically ']]/*[@class='android.widget.Button']")
    private List<WebElement> sortByOptions;

    @AndroidFindBy(xpath = "\t\n" + "//android.view.View[contains(@content-desc,\"Good Morning ☀\uFE0F Drink water & take your medications\"]")
    private WebElement greetingsMsg;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Filter options. Currently filtering by Recent Rx.']")
    private WebElement filterOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.ScrollView")
    private List<WebElement> medicinesList;

WaitHelpers waitHelpers = new WaitHelpers();
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
        validateText(myRx, "content-desc", "My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.");
        return this;
    }

    public RxHomePage validateMoreBBtn() {
        validateElement(moreBtn, "More button");
        final String expectedTextToBeDisplayed = "More tab. 3 of 3. Tap for settings, support and other options.";
        validateText(moreBtn, "content-desc", expectedTextToBeDisplayed);
        return this;
    }

    public RxHomePage enterMedicinesNameInSearchField(String medicineName) {
        clickOnSearchBtn();
        click(enterInSearch, "search field");
        hideKeyboard();
        sendTextUsingJS(medicineName);

        try {
            WaitHelpers.waitTime(30);
            if (DriverManager.getDriver().findElement(By.xpath("//*[@content-desc=" + '"' + medicineName + '"' + "]"))
                    .isDisplayed()) {
                ExtentLogger.pass("Drugs are available for " + medicineName + "+");
            }
        } catch (Exception e) {
            throw new RuntimeException("Either drugs are not available for " + medicineName + "+ or service is down");
        }
        return this;
    }

    public void
    validateDrugDetailpage() {
        click(drugName, "amoxiline");
        // validateText(rxFilterTitle, "content-desc","Customize your 'Amoxicillin Trihydrate' search");
//        String elementAttribute = rxFilterTitle.getAttribute("content-desc");
//System.out.println(elementAttribute);


        waitHelpers.waitUntilElementToBeClickable(showDetailsBtn);
        showDetailsBtn.click();
        TouchAction action = new TouchAction((PerformsTouchActions) DriverManager.getDriver());
        //DriverManager.getDriver().findElements(By.xpath("//*[@class='android.widget.HorizontalScrollView']/*[@class='android.widget.Button']")).size() == 0

        waitHelpers.waitUntilElementToBeClickable(showLocation);
        showLocation.click();
        waitHelpers.waitUntilElementToBeClickable(nearMyLocation);
        nearMyLocation.click();


        horizontalScroll(pharmaciesList, 498, 1096, 206, 1086);


    }


    public RxHomePage verifyNumberOfMedicinesDisplayOnSearchResult(int count) {
        WaitHelpers.waitTime(5);
        hideKeyboard();
        if (medicineList.size() != 0) {
            Assert.assertEquals(medicineList.size(), count);
            ExtentLogger.pass(count + " medicines displayed on the page");
        } else {
            throw new RuntimeException("List is empty");
        }
        return this;
    }

    public RxHomePage validateMedicineNameStartsWith(String medicinesNameToValidate) {
        List<WebElement> elementList = DriverManager.getDriver().findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button"));

        String[] ls = new String[elementList.size()];
        boolean status = false;
        for (WebElement element : elementList) {
            if (elementList.size() != 0) {
                if (element.getAttribute("content-desc").startsWith(medicinesNameToValidate)) {
                    String elementAttribute = element.getAttribute("content-desc");
                    ls = new String[]{elementAttribute};
                    ExtentLogger.pass(Arrays.toString(ls));
                    status = true;
                }
            } else {
                ExtentLogger.fail("Medicines list is empty");
            }
        }

        if (status) {
            ExtentLogger.info("All medicines displayed");
            ExtentLogger.pass("All medicines starts with " + medicinesNameToValidate + "");
        } else {
            ExtentLogger.fail("Medicines name not starts with " + medicinesNameToValidate + " ");
        }
        return this;
    }


    public RxHomePage validateCloseBtnAndCloseSearch() {
        if (searchCloseBtn.isDisplayed()) {
            Assert.assertEquals(searchCloseBtn.getAttribute("content-desc"), "Close Search");
            click(searchCloseBtn, "Close btn");
        } else {
            ExtentLogger.fail("Close btn on search screen is not enable or displayed");
        }
        return this;
    }


    public RxHomePage filterByFamilyMember(String familyMemberName) {
        click(filterByFamilyMember, "filterByFamilyMember");
        boolean status = false;
        for (int i = 0; i < familyMemberList.size(); i++) {
            if ((familyMemberList.get(i).getAttribute("content-desc").trim().equalsIgnoreCase(familyMemberName))) {
                WebElement familyMemName = familyMemberList.get(i);
                click(familyMemName, familyMemberName);
                WaitHelpers.waitTime(5);
                status = false;
                break;
            } else {
                status = true;
            }
        }
        if (status) {
            ExtentLogger.fail("FamilyName " + familyMemberName + " is not selected, Please check the family name provided");
        }
        return this;
    }


    public RxHomePage ValidatefilterByFamily() {
        validateElement(filterByFamilyMember, "FilterByFamilyMember");
        validateText(filterByFamilyMember, "content-desc", "Filter options. Currently filtering by Dorothy Scott.");
        return this;
    }


    public RxHomePage sortByAlphaOrder(String sortByOption) {
        List<String> sortedList = actualSortedList();
        List<String> afterSortingAlpabetically = null;

        click(sortBy, "Sort By:");
        boolean status = false;
        for (int i = 0; i < sortByOptions.size(); i++) {
            if ((sortByOptions.get(i).getAttribute("content-desc").trim().equalsIgnoreCase(sortByOption))) {
                WebElement option = sortByOptions.get(i);
                click(option, sortByOption);
                WaitHelpers.waitTime(5);
                afterSortingAlpabetically = myRxHomeDrugList.stream().map(new NativeBasePage()::getText).collect(Collectors.toList());
                status = false;
                break;
            } else {
                status = true;
            }
        }
        if (status) {
            ExtentLogger.fail("Sort by option " + sortByOption + " is not selected, Please check the sort by");
        }
        boolean areEqual = actualSortedList().equals(afterSortingAlpabetically);

        if (areEqual) {
            ExtentLogger.pass("Rx page drug list is alphabetically sorted");
        } else {
            ExtentLogger.fail("Rx page drug list is not alphabetically sorted");
        }
        return this;
    }

    private static List<String> actualSortedList() {
        List<WebElement> homeDrugList = myRxHomeDrugList;
        List<String> actualList = homeDrugList.stream().map(new NativeBasePage()::getText).sorted().collect(Collectors.toList());
        return actualList;
    }
}
