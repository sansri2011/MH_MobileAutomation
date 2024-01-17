package org.magellanhealth.testcases;

import org.magellanhealth.pages.LoginPage;
import org.magellanhealth.pages.MoreTabPage;
import org.magellanhealth.utils.DataProviderUtils;
import org.magellanhealth.utils.PropertyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreTabTest extends BaseTest {
    static String username = PropertyUtils.getValue("appUsername7");
    static String password = PropertyUtils.getValue("appPassword7");


    @Test(groups = "SmokeTest", dataProvider = "getData", dataProviderClass = DataProviderUtils.class,
            description = "Verify login page", enabled = false)
    public static void validateMoreTabTest(Map<String, String> map) {

        new LoginPage()
                .loginToApp(username, password);

        new MoreTabPage()
                .clickOnMoreTab()
                .validateNoOfFAQAndContacts();
    }


}
