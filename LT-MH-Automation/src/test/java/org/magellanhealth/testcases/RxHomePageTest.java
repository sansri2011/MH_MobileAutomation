package org.magellanhealth.testcases;

import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.pages.RxHomePage;
import org.magellanhealth.utils.DataProviderUtils;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.Test;

import java.util.Map;

public class RxHomePageTest extends BaseTest {
    ThreadLocal<String> username = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appUsername7"));
    ThreadLocal<String> password = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appPassword7"));


    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, enabled = true)
    public void verifyElementsOnRxHomePageTest(Map<String, String> map) throws InterruptedException {
        new LoginPage()
                .loginToApp(username.get(), password.get());
        new RxHomePage().checkUsernameDisplayOnRxHomePage()
                .validateFilterby()
                .validateSearchBtn()
                .validateGoToRxSearchBtn()
                .validateRxHistoryBtn()
                .validateMyRxBtn()
                .validateMoreBBtn();
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, enabled = true)
    public void validateRxHomePage(Map<String, String> map) {
        new LoginPage().loginToApp(username.get(), password.get());
        new RxHomePage()
                .enterMedicinesNameInSearchField("Amoxicillin")
                .verifyNumberOfMedicinesDisplayOnSearchResult(7)
                .validateMedicineNameStartsWith("Amox")
                .validateCloseBtnAndCloseSearch()
                .ValidatefilterByFamily()
                .filterByFamilyMember("Hunter Scott")
                .sortByAlphaOrder("Alphabetically");
    }

    @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class, enabled = true)
    public void validateDrugDetailsPage(Map<String, String> map) {
        ThreadLocal<String> username = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appUsername1"));
        ThreadLocal<String> password = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appPassword1"));
        new LoginPage().loginToApp(username.get(), password.get());
        new RxHomePage()
                .enterMedicinesNameInSearchField("Amoxicillin")
                .validateDrugDetailpage();
    }
}
