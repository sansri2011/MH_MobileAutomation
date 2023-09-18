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

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    public LoginPageTest() {
        LoginPage loginPage = new LoginPage();
    }


    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify Sign-in Screen(Default screen for the user)", enabled = true)
    public void verifySignInScreen(Map<String, String> map) {
        new LoginPage().verifyElementOnScreen();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify Email Keyboard appears", enabled = false)
    public void emailKeyboardAppears(Map<String, String> map) {
        new LoginPage().verifyKeyboardShownForEmail();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify Password Keyboard appears", enabled = false)
    public void pwdKeyboardAppears(Map<String, String> map) {
        new LoginPage().verifyKeyboardShownForPassword();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1",
            description = "Verify and validate Email field allows only 50 characters", enabled = false)
    public void usernameAccept50char(Map<String, String> map) {
        new LoginPage().verifyEmailIdAccept50Char();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify and Validate App Allows Pasting on the Email field Copy more than 50 characters ")
    public void checkCopyPateMoreThan50Char(Map<String, String> map) {
        new LoginPage().copyPast50Char();
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify Sign in with Invalid Email address")
    public void InvalidEmailTest(Map<String, String> map) {
        new LoginPage().invalidEmailId("shaalini");
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify Sign in with invalid Password")
    public void InvalidPasswordTest(Map<String, String> map) {
        new LoginPage().invalidPassword("Testing");
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify blank spaces in Email and password")
    public void InvalidUserAndPass(Map<String, String> map) {
        new LoginPage().invalidUsernamePasswd("     ", "       ");
    }


    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify blank spaces in Email and password")
    public void InvalidPassword(Map<String, String> map) {
        new LoginPage().enterInvalidPassword(PropertyUtils.getValue("appUsername"));
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify blank spaces in Email and password")
    public void InvalidCredentialsTest(Map<String, String> map) {
        new LoginPage().enterInvalidUsernamePassword("invalid@gmail.com", "invalidPassword");
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify the Sign in button is disabled if any previously filled field is cleared")
    public void SignInStateAfterClearingField(Map<String, String> map) {
        new LoginPage().signBtnState(PropertyUtils.getValue("appUsername"), PropertyUtils.getValue("appPassword"));
    }


    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify the user successfully login with onboarding carousel screens")
    public void loginAndValidateTest(Map<String, String> map) {
        new LoginPage().signInToApp(PropertyUtils.getValue("appUsername"), PropertyUtils.getValue("appPassword"));
    }

    @Test(groups = "LoginTest", dataProvider = "getData1", enabled = false,
            description = "Verify the App dismisses the Onboarding screen if the Skip  tutorial button is tapped")
    public void skipTutorialTest(Map<String, String> map) {
        new LoginPage()
                .skipTutorial(PropertyUtils.getValue("appUsername"), PropertyUtils.getValue("appPassword"));
    }

    @Test(groups = "LoginTest",
            dataProvider = "getData1",
            enabled = false,
            description = "Verify the App does not display the Onboarding screens (after Sign in with different user)")
    public void notDisplayOnboardingScreenTest(Map<String, String> map) {
        new LoginPage().notDisplayOnboardingScreen(PropertyUtils.getValue("appUsername"),
                PropertyUtils.getValue("appPassword"),
                PropertyUtils.getValue("appUsername1"),
                PropertyUtils.getValue("appPassword1"));
    }

    @Test(groups = "LoginTest",
            dataProvider = "getData1", enabled = false,
            description = "Accessing the Sign In / Password expired screen when User Password expires")
    public void validateExpiredPasswordTest(Map<String, String> map) {
        new LoginPage().validateExpiredPassword(PropertyUtils.getValue("appUsername1"),
                PropertyUtils.getValue("appPassword1"));
    }

    @Test(groups = "LoginTest",
            dataProvider = "getData1", enabled = false,
            description = "Verify the Sign In / Account locked screen by trying to Sign in with a Locked Account")
    public void validateSignInOnLockedScreenTest(Map<String, String> map) {
        new LoginPage().SignInOnLockedScreen(PropertyUtils.getValue("appUsername4"),
                PropertyUtils.getValue("appPassword4"));
    }


    @Test(groups = "forgetPwd",
            dataProvider = "getData1", enabled = false,
            description = "Verify the App Allows the user to tap forgot your password?")
    public void validateForgotPasswordTest(Map<String, String> map) {
        new LoginPage().validateForgotPassword();
        new ForgotPasswordPage().forgotPasswordPageTitle().chedkPresenceOfForgotPwdFieldText()
                .validateErrorOnInvalidForgotPwdField();
    }

   // @Test(groups="forgetPwd",dataProvider = "getData1",enabled = true,description="Verify the App allows to tap Forgotpassword? link")
    //public void validateForgotPasswordTest(Map<String,String>map){
        //new LoginPage().validateForgotPassword();
       // new ForgotPasswordPage().forgotPasswordPageTitle().chedkPresenceOfForgotPwdFieldText();
   // }

    @Test(groups = "forgetPwd",
            dataProvider = "getData1", enabled = false,
            description = "Verify and validate App allows maximum of 50 characters for the Email Address field")
    public void validateContinueBtnStateAfterEnteringEmailInForgotPwd(Map<String, String> map) {
        new LoginPage().validateForgotPassword();
        new ForgotPasswordPage().verifyEmailIdAccept50Char();
    }

    @Test(groups = "forgetPwd",
            dataProvider = "getData1", enabled = false,
            description = "Verify and validate App allows maximum of 50 characters for the Email Address field")
    public void verifyForgotPasswordEmail(Map<String, String> map) {
        new LoginPage().validateForgotPassword();
        new ForgotPasswordPage().enterEmailAndContinue(PropertyUtils.getValue("forgotPasswordEmail"));
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
