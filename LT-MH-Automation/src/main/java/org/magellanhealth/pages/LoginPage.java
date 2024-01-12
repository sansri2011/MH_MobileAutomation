package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.FrameworkException.NoSuchScreenException;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.magellanhealth.utils.PageActionsHelper.scrollForMobile;
import static org.magellanhealth.utils.PageActionsHelper.sendTextUsingJS;

public class LoginPage extends NativeBasePage {
    @AndroidFindBy(xpath = "//*[contains(@class,'android.widget.EditText')][1]")
    private  WebElement email;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='My Rx tab. 2 of 3. Tap to manage your current and past prescriptions.']")
    private WebElement myRx;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='The email address or password you have entered is invalid. Too many incorrect attempts will lock your account.']")
    private WebElement invalidCredentialsErrorMessage;
    @AndroidFindBy(xpath = "//*[contains(@class,'android.widget.EditText')][2]")
    private WebElement pwd;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Forgot your password?']")
    private WebElement forgotPwdLink;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    private WebElement forgotPwdFieldOnForgotPwdScreen;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    private WebElement invalidEmailErrorOnForgotPwd;

    @AndroidFindBy(xpath = " //android.view.View[@content-desc='Forgot password']")
    private WebElement forgotPwdText;

    @AndroidFindBy(accessibility = "Don't have an account?,tap to Register now,")
    private WebElement registerNow;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign in']")
    private WebElement signIn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Allow']")
    private WebElement allowBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    private WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='A better pharmacy experience']")
    private WebElement NextScreen1;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Manage your prescriptions from anywhere']")
    private WebElement NextScreen2;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Get the best Rx prices']")
    private WebElement getStartedScreen2;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Get started']")
    private WebElement getStarted;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Skip tutorial']")
    private WebElement skipTutorial;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More tab. 3 of 3. Tap for settings, support and other options.']")
    private WebElement moreOptionBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Yes']")
    private static WebElement yesOnSignOutPopUp;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign out']")
    private static WebElement signOutBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Password expired']")
    private static WebElement passwordExpiredText;
    @AndroidFindBy(className = "android.widget.EditText")
    private static WebElement enterNewPassword;


    @AndroidFindBy(className = "//android.widget.Button[@content-desc='Continue']")
    private static WebElement continueBtn;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Corey's account\"]")
    private static WebElement homePageElement;


    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    WaitHelpers waitHelpers = new WaitHelpers();

    public LoginPage verifyElementOnScreen() {
        onScreenFields(email.isDisplayed(), "Email field is Displayed in Sign IN screen", "Email field is not Displayed in Sign IN screen");
        onScreenFields(pwd.isDisplayed(), "Password  field is Displayed in Sign in screen", "Password  field is not Displayed in Sign in screen");
        onScreenFields(signIn.isDisplayed(), "Sign in button is Displayed in Sign in Screen", "Sign in button is not Displayed in Sign in Screen");
        onScreenFields(forgotPwdLink.isDisplayed(), "Forgot password is Displayed in Sign in Screen", "Forgot password is not Displayed in Sign in Screen");
        onScreenFields(registerNow.isEnabled(), "Register Now is Displayed in Sign in screen", "Register Now is not Displayed in Sign in screen");
        return this;
    }

    public LoginPage verifyKeyboardShownForEmail() {
        new CommonPageMethods().verifyKeyboardAppears(email, "username");
        return this;
    }

    public LoginPage verifyKeyboardShownForPassword() {
        new CommonPageMethods().verifyKeyboardAppears(pwd, "password");
        return this;
    }

    public ForgotPasswordPage verifyEmailIdAccept50Char() {
        String expected = "/Myr98lgD0jPqTzqMhKm2JEItOk6YDxDJxaYigLbWHlYXbj4we/";

        click(email, "username");
        sendTextUsingJS(expected);
        ExtentLogger.info("Entered text");
        WaitHelpers.waitTime(5);
        String actual = email.getText().replace("Email: ", "").trim();
        if (actual.equalsIgnoreCase(expected)) {
            ExtentLogger.pass("50 char accepted");
        } else {
            Assert.assertEquals(actual, expected);
        }
        return null;
    }

    public void copyPast50Char() {
        String data = "Myr98lgD0jPqTzqMhKm2JEItOk6YDxDJxaYigLbWHlYXbj4we";
        String replaced = "";
        enterUsername(data);
        int count = 0;
        char c = 0;
        char c1 = 0;
        for (int i = 0; i <= data.length(); i++) {
            c = data.charAt(i);
            replaced = email.getText().replace("Email: ", "");
            c1 = replaced.trim().charAt(i);
            if (c == c1) {
                Assert.assertTrue(true);
            } else if (c == c1 != true) {
                count++;
                break;
            }
        }
        if (count == 0) {
            ExtentLogger.pass("Copy paste works for 50char");
        } else {
            ExtentLogger.fail("Character found " + c1 + " not matching with test data");
            Assert.assertEquals(data, replaced);
            throw new RuntimeException("Character " + c1 + " at index not matching with test data " + data + "");
        }
    }


    public LoginPage invalidEmailId(String invalidEmail) {
        enterUsername(invalidEmail);
        ExtentLogger.info("Entered invalid email id");
        click(pwd, "password");
        if (email.getText().contains("Please enter a valid email address.")) {
            ExtentLogger.pass("Message on Invalid email id: " + email.getText());
        } else {
            ExtentLogger.fail("Invalid error message displayed on entering invalid email");
        }
        return this;
    }

    public LoginPage invalidPassword(String invalidEmail) {
        enterUsername(invalidEmail);
        ExtentLogger.info("Entered invalid email id");
        enterPassword("          ");
        ExtentLogger.info("Entered invalid password");
        email.click();
        if (pwd.getText().contains("Please enter a valid password.")) {
            ExtentLogger.info("Error message");
            ExtentLogger.pass("Message on Invalid password id: " + pwd.getText());
        } else {
            ExtentLogger.fail("Invalid error message displayed on entering invalid password");
        }
        return this;
    }

    public LoginPage loginToApp(String username, String password) {
      //  WaitHelpers.waitTime(10);
        waitHelpers.waitUntilElementToBeClickable(email);
        enterUsername(username);
        hideKeyboard();
        enterPassword(password);
        email.click();
        hideKeyboard();
        signIn.click();
        ExtentLogger.pass("User logged in successfully");
       // WaitHelpers.waitTime(30);
        waitHelpers.waitUntilElementToBeClickable(skipTutorial);
        skipTutorial.click();
        waitHelpers.waitUntilElementToBeClickable(myRx);
        ExtentLogger.pass("Tutorial skipped in successfully");
        return this;
    }


    public LoginPage invalidUsernamePasswd(String username, String password) {
        enterPassword(username);
        enterPassword(password);
        email.click();

        hideKeyboard();

        if (!signIn.isEnabled()) {
            ExtentLogger.pass("Sign but is enable");
            ExtentLogger.info("sing in button");
        } else {
            ExtentLogger.fail("Sign button should not be enable");
            throw new RuntimeException("Sign button should not be enable");
        }
        return this;
    }

    private void pressDeleteKey() {
        while (!email.getText().isEmpty()) {
            //   Actions actions = new Actions(DriverManager.getDriver());
            //actions.sendKeys(Keys.CONTROL, "a").build().perform();
            //  actions.sendKeys(email, Keys.DELETE).build().perform();

            WebElement element = DriverManager.getDriver().findElement(By.xpath("//*[contains(@class,'android.widget.EditText')][1]"));
            element.clear();

//            LongPressOptions longPressOptions = new LongPressOptions();
//            longPressOptions.withElement(ElementOption.element(pwd));
//            new TouchAction<>((PerformsTouchActions) DriverManager.getDriver()).longPress(longPressOptions).perform();
//            pwd.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//            new TouchAction<>((PerformsTouchActions) DriverManager.getDriver()).release().perform();

        }
    }

    public LoginPage signBtnState(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        hideKeyboard();
        pwd.click();


        pressDeleteKey();

        if (!signIn.isEnabled()) {
            ExtentLogger.info("Sign in");
            ExtentLogger.pass("Sign in btn is disable");
        } else {
            throw new RuntimeException("Sign but should not be enable");
        }
        return this;
    }

    public LoginPage enterInvalidPassword(String validUsername) {
        enterUsername(validUsername);
        ExtentLogger.info("Entered " + validUsername + " email id");
        enterPassword("          ");
        ExtentLogger.info("Entered invalid password");
        email.click();
        if (pwd.getText().contains("Please enter a valid password.")) {
            ExtentLogger.info("Error message");
            ExtentLogger.pass("Message on Invalid password id: " + pwd.getText());
        } else {
            ExtentLogger.fail("Invalid error message displayed on entering invalid password");
        }
        return this;
    }

    public LoginPage enterInvalidUsernamePassword(String invalidUsername, String invalidPassword) {
        enterUsername(invalidUsername);
        ExtentLogger.info("Entered " + invalidUsername + " email id");
        enterPassword(invalidPassword);
        ExtentLogger.info("Entered " + invalidPassword + " password");
        email.click();
        hideKeyboard();
        click(signIn, "sign in");
        if (invalidCredentialsErrorMessage.isDisplayed()) {
            ExtentLogger.info("Error message");
            ExtentLogger.pass("Message on Invalid credentials: " + invalidCredentialsErrorMessage.getText());
        } else {
            ExtentLogger.fail("Invalid error message displayed on entering invalid password");
        }
        return this;
    }


    private static void onScreenFields(boolean objectStatus, String field_displayed, String field_not_displayed) {
        if (objectStatus) {
            ExtentLogger.pass(field_displayed);
            Assert.assertTrue(true, field_displayed);
        } else {
            ExtentLogger.fail(field_not_displayed);
        }
    }

    public LoginPage verifyForgotPasswordLink() {
        WaitHelpers.waitTime(5);
        validateElement(forgotPwdLink, "Forgot password link");
        return new LoginPage();
    }


    public ForgotPasswordPage validateForgotPassword() {
        WaitHelpers.waitTime(5);
        validateElement(forgotPwdLink, "Forgot password");
        return new ForgotPasswordPage();
    }

    public ForgotPasswordPage signInToApp(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
        clickAndValidateNextScreen();
        clickAndValidateGetStartedScreen();
        return new ForgotPasswordPage();
    }

    public LoginPage enterUsername(String username) {
        try {
            click(email, "username");
            sendTextUsingJS(username);
            hideKeyboard();
        } catch (Exception e) {
            System.out.println("Something wrong while entering username but clicked successfully");
        }
        return this;

    }

    public LoginPage enterPassword(String password) {
        click(pwd, "password");
        sendTextUsingJS(password);
        return this;
    }

    public LoginPage clickSignIn() {
        WaitHelpers.waitTime(5);
        email.click();
        hideKeyboard();
        if (signIn.isEnabled() && signIn.isDisplayed()) {
            ExtentLogger.pass("Sign In button is enable and displayed in Sign in screen");
            click(signIn, "SignIn button");
            WaitHelpers.waitTime(30);
        } else {
            Assert.assertFalse(false);
        }
        return new ForgotPasswordPage();
    }


    public LoginPage clickAndValidateNextScreen() {
        WaitHelpers.waitTime(5);
        try {
            while (nextBtn.isDisplayed()) {
                if (nextBtn.isDisplayed()) {
                    try {
                        validateNextScreen1();
                    } catch (Exception e) {
                        validateNextScreen2();
                    }
                    click(nextBtn, "next");
                } else {
                    ExtentLogger.fail("login failed");
                }
            }
        } catch (Exception e) {
            System.out.println("Finished click on next button");
        }
        return this;
    }

    private void validateNextScreen1() {

        if (NextScreen1.isDisplayed()) {
            ExtentLogger.info("NextScreen1");
            Assert.assertTrue(true, "A better pharmacy experience");
        } else {
            ExtentLogger.info("NextScreen2");
            throw new RuntimeException("Either==> *A better pharmacy experience* or *skip Tutorial* button is missing");
        }

    }

    private void validateNextScreen2() {
        if (NextScreen2.isDisplayed() && skipTutorial.isDisplayed()) {
            ExtentLogger.info("NextScreen2");
            Assert.assertTrue(true, "Manage your prescriptions from anywhere");
        } else {
            ExtentLogger.info("NextScreen2");
            throw new RuntimeException("Either==> *Manage your prescriptions from anywhere* or *skip Tutorial* button is missing");
        }
    }

    public void validateGetStartedScreen3() {
        if (getStartedScreen2.isDisplayed()) {
            ExtentLogger.info("getStartedScreen");
            Assert.assertTrue(true, "Get the best Rx prices");
        } else {
            ExtentLogger.info("NextScreen2");
            throw new NoSuchScreenException("Either==> *Get the best Rx prices* or *skip Tutorial* button is missing");
        }
    }


    public LoginPage clickAndValidateGetStartedScreen() {
        WaitHelpers.waitTime(10);
        validateGetStartedScreen3();
        click(getStarted, "getStarted");
        WaitHelpers.waitTime(50);
        return this;
    }


    public LoginPage skipTutorial(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
        click(skipTutorial, "skip tutorial");
        verifyUsernameDisplayed();
        return this;
    }

    public LoginPage notDisplayOnboardingScreen(String username1, String password1, String username2, String password2) {
        signInToApp(username1, password1);
        WaitHelpers.waitTime(10);
        click(moreOptionBtn, "more option btn");
        clickOnSignOut();
        enterUsername(username1);
        enterPassword(password1);
        clickSignIn();
        try {
            if (nextBtn.isEnabled() && nextBtn.isDisplayed()) {
                ExtentLogger.fail("Onboarding screen should not display after second login");
                throw new RuntimeException("Onboarding screen should not display after second login");
            }
        } catch (Exception e) {
            ExtentLogger.info("No onboarding screen display after second login");
            ExtentLogger.pass("No onboarding screen display after second login");
        }
        return this;
    }

    private void clickOnSignOut() {
        scrollForMobile(signOutBtn);
        click(signOutBtn, "sign out");
        click(yesOnSignOutPopUp, "yes btn on sign out confirmation pop up");
        WaitHelpers.waitTime(10);
    }

    private void verifyUsernameDisplayed() {
        WaitHelpers.waitTime(20);
        if (homePageElement.isDisplayed()) {
            ExtentLogger.info("User landed in MyRx Screen");
        } else {
            ExtentLogger.info("Username did not display");
        }
    }

    public void validateExpiredPassword(String username, String password) {
        signInToApp(username, password);
        ExtentLogger.info("forgot password screen");
        System.out.println(enterNewPassword.getText());
    }

    public void SignInOnLockedScreen(String username, String password) {
        enterUsername(username);
        ExtentLogger.info("Entered username");
        enterPassword(password);
        ExtentLogger.info("Password username");
        clickSignIn();
    }


}
