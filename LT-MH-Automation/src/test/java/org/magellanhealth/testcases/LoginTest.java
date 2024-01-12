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

public class LoginTest extends BaseTest {


    @Test(groups = "SmokeTest", dataProvider = "getData1",
            description = "Verify login page", enabled = false)
    public void verifySignInScreen(Map<String, String> map) {
        //new ForgotPasswordPage()
               // .verifyForgotPasswordLink();
        new LoginPage().verifyElementOnScreen()
                .verifyKeyboardShownForEmail()
                .verifyKeyboardShownForPassword()
                .enterUsername(PropertyUtils.getValue("appUsername1"))
                .enterPassword(PropertyUtils.getValue("appPassword1"))

                .clickSignIn()
                .clickAndValidateNextScreen()
                .clickAndValidateGetStartedScreen();

    }
    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify and validate Email field allows only 50 characters", enabled = false)
    public void usernameAccept50char(Map<String, String> map) {
        new LoginPage().verifyEmailIdAccept50Char();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Invalid test case - Verify Sign in with Invalid Email address")
    public void InvalidEmailTest(Map<String, String> map) {
        new LoginPage().invalidEmailId("shaalini");
    }



    @DataProvider(parallel = false)
    public Object[] getData1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", "Galaxy S22 5G");
        map.put("os_version", "12");

        HashMap<String, String> map2 = new HashMap<>();
//        map2.put("deviceName", "Galaxy S23+");
//        map2.put("platformVersion", "13");
        map2.put("deviceName", "Google Pixel 7 Pro");
        map2.put("platformVersion", "12");

        HashMap<String, String> map3 = new HashMap<>();
//        map3.put("deviceName", "iPhone 14 Pro");
//        map3.put("platformVersion", "16");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map);
        return list.toArray();
    }


}
