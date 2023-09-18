package org.magellanhealth.testcases;

import org.magellanhealth.pages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePageTest {

    @Test(dataProvider = "getData1")
    public void loginTest(Map<String, String> map) throws InterruptedException {
        new HomePage().loginPage();
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
