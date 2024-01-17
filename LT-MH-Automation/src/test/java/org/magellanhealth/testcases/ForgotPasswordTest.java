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

public class ForgotPasswordTest extends BaseTest {

    @Test(groups = "SmokeTest",dataProvider = "getData", dataProviderClass = DataProviderUtils.class,
            description = "Verify login page", enabled = false)
    public void verifyForgotPasswordScreen(Map<String, String> map) {
        String username = PropertyUtils.getValue("appUsername");
        String password = PropertyUtils.getValue("appPassword");
        new ForgotPasswordPage().
                validateForgotPassword()
                .forgotPasswordPageTitle()
                .enterEmailAndContinue(username)
                .clickOnReturnToSignIn();

    }


}
