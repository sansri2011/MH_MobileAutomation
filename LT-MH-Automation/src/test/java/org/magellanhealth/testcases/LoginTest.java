package org.magellanhealth.testcases;

import org.magellanhealth.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {


    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify login page", enabled = true)
    public void verifySignInScreen(Map<String, String> map) {
        new LoginPage().verifyElementOnScreen().verifyKeyboardShownForEmail();
    }

}
