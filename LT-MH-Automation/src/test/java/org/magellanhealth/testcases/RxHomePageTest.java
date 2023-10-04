package org.magellanhealth.testcases;

import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.pages.RxHomePage;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RxHomePageTest extends BaseTest{

    @Test(dataProvider = "getData1")
    public void RxHomePageTest(Map<String, String> map) throws InterruptedException {
        new LoginPage().verifyElementOnScreen()
                .verifyKeyboardShownForEmail()
                .verifyKeyboardShownForPassword()
                .enterUsername(PropertyUtils.getValue("appUsername7"))
                .enterPassword(PropertyUtils.getValue("appPassword7"))
                .clickSignIn();
        new RxHomePage().validateListOfMedicines();

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
}
