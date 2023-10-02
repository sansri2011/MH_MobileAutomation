package org.magellanhealth.testcases;

import org.magellanhealth.pages.ForgotPasswordPage;
import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForgotPasswordTest extends BaseTest {

    @Test(groups = "SmokeTest", dataProvider = "getData1",
            description = "Verify login page", enabled = true)
    public void verifyForgotPasswordScreen(Map<String, String> map) {
        String username = PropertyUtils.getValue("appUsername7");
        String password = PropertyUtils.getValue("appPassword7");
        new ForgotPasswordPage().
                validateForgotPassword()
                .forgotPasswordPageTitle()
                .enterEmailAndContinue(username)
                .clickOnReturnToSignIn();

    }


    @DataProvider(parallel = false)
    public Object[] getData1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", "Galaxy S22 5G");
        map.put("os_version", "12");

        HashMap<String, String> map2 = new HashMap<>();


        HashMap<String, String> map3 = new HashMap<>();
//        map3.put("deviceName", "iPhone 14 Pro");
//        map3.put("platformVersion", "16");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map2);
        return list.toArray();
    }
}
