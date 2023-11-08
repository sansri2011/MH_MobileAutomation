package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MoreTabPage extends NativeBasePage {
    @AndroidFindBy(xpath = "//*[@content-desc='FAQs & Contact']")
    private static WebElement FAQsAndContact;

    @AndroidFindBy(xpath = " //*[@content-desc='More tab. 3 of 3. Tap for settings, support and other options.']")
    private static WebElement moreTab;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ScrollView']/*[@class='android.view.View']")
    private static List<WebElement> listOfFAQsAndContact;
    @AndroidFindBy(xpath = "//*[@content-desc='Contact us']")
    private static WebElement ContactUSBtn;


    public MoreTabPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public MoreTabPage clickOnMoreTab() {
        click(moreTab, "More tab");
        return new MoreTabPage();
    }

    public MoreTabPage ValidateFAQAndContactBtn() {
        validateElement(FAQsAndContact, "FAQs And Contact");
        validateText(FAQsAndContact, "content-desc", "FAQs & Contact");
        return new MoreTabPage();
    }

    public void validateNoOfFAQAndContacts() {
        click(FAQsAndContact, "FAQsAndContact");
        WaitHelpers.waitTime(5);
        Set<String> list = new HashSet<String>();
        ArrayList<String> list1 = new ArrayList<>(list);

        for (WebElement ele1 : listOfFAQsAndContact) {
            list.add(ele1.getAttribute("content-desc"));
        }
        int mastSize = 0;
        mastSize = listOfFAQsAndContact.size();
        scrollToElement(ContactUSBtn);
        for (WebElement ele1 : listOfFAQsAndContact) {
            list.add(ele1.getAttribute("content-desc"));
        }
        mastSize = mastSize + listOfFAQsAndContact.size();
       list.stream().filter(text -> !text.endsWith("?")).count();//.collect(Collectors.toList()).forEach(System.out::println);

        Assert.assertEquals(list.size()-3, 13, "19 FAQ displayed" + "");
        ExtentLogger.pass(list.size()-3 + " FAQ are present");

    }

    public MoreTabPage ValidateFaqAndContact() {

        return new MoreTabPage();
    }
}
