package org.magellanhealth.testcases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.pages.RxHomePage;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RxHomePageTest extends BaseTest {
    String username = PropertyUtils.getValue("appUsername7");
    String password = PropertyUtils.getValue("appPassword7");

    @Test(dataProvider = "getData1", enabled = false)
    public void verifyElementsOnRxHomePageTest(Map<String, String> map) throws InterruptedException {

        new LoginPage()
                .loginToApp(username, password);

        new RxHomePage().checkUsernameDisplayOnRxHomePage()
                .validateFilterby()
                .validateSearchBtn()
                .validateGoToRxSearchBtn()
                .validateRxHistoryBtn()
                .validateMyRxBtn()
                .validateMoreBBtn();
    }

    @Test(dataProvider = "getData1", enabled = false)
    public void validateRxHomePage(Map<String, String> map) {
        new LoginPage().loginToApp(username, password);
        new RxHomePage()
                .enterMedicinesNameInSearchField("Amoxi")
                .verifyNumberOfMedicinesDisplayOnSearchResult(7)
                .validateMedicineNameStartsWith("Amox")
                .validateCloseBtnAndCloseSearch()
                .ValidatefilterByFamily()
                .filterByFamilyMember("Hunter Scott")
                .sortByAlphaOrder("Alphabetically");
    }

    @Test(dataProvider = "getData1", enabled = true)
    public void validateDrugDetailsPage(Map<String, String> map) {
        String username = PropertyUtils.getValue("appUsername1");
        String password = PropertyUtils.getValue("appPassword1");
        new LoginPage().loginToApp(username, password);
        new RxHomePage()
                .enterMedicinesNameInSearchField("Amoxi")
                .validateDrugDetailpage();


    }
    @DataProvider(parallel = true)
    public Object[] getData1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", "Galaxy S22 5G");
        map.put("os_version", "12");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("device", "Galaxy S23+");
        map2.put("os_version", "13");

        HashMap<String, String> map3 = new HashMap<>();
//        map3.put("deviceName", "iPhone 14 Pro");
//        map3.put("platformVersion", "16");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map3);
        return list.toArray();
    }

    @DataProvider(parallel = true)
    public Object[] getData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<Map<String, Object>> list = mapper.readValue(new File(System.getProperty("user.dir")
                + "src/test/resources/jsontestdata/iteration.json"), new TypeReference<List<Map<String, Object>>>() {
        });

        return list.toArray();
    }
}
