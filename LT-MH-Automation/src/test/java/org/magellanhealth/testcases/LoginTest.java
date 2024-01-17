package org.magellanhealth.testcases;

import org.magellanhealth.pages.ForgotPasswordPage;
import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.utils.DataProviderUtils;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {


    @Test(groups = "SmokeTest", dataProvider = "getData", dataProviderClass = DataProviderUtils.class,
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
    @Test(groups = "LoginTest", dataProvider = "getData", dataProviderClass = DataProviderUtils.class,
            description = "Verify and validate Email field allows only 50 characters", enabled = true)
    public void usernameAccept50char(Map<String, String> map) {
        new LoginPage().verifyEmailIdAccept50Char();
    }

    @Test(groups = "LoginTest", dataProvider = "getData", dataProviderClass = DataProviderUtils.class, enabled = true,
            description = "Invalid test case - Verify Sign in with Invalid Email address")
    public void InvalidEmailTest(Map<String, String> map) {
        new LoginPage().invalidEmailId("shaalini");
    }




}
