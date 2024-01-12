package org.magellanhealth.testcases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.pages.RxHomePage;
import org.magellanhealth.utils.DataProviderUtils;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class RxHomePageTest extends BaseTest {
    ThreadLocal<String> username = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appUsername7"));
    ThreadLocal<String> password = ThreadLocal.withInitial(() -> PropertyUtils.getValue("appPassword7"));

    @Test(dataProvider = "getData1", enabled = false)
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

    @Test(dataProvider = "getData", enabled = false)
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
