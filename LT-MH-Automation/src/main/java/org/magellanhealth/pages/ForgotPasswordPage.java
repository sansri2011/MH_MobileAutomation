package org.magellanhealth.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.magellanhealth.Report.ExtentLogger;
import org.magellanhealth.driverManager.DriverManager;
import org.magellanhealth.utils.WaitHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.magellanhealth.utils.PageActionsHelper.clickByCoordinates;
import static org.magellanhealth.utils.PageActionsHelper.sendTextUsingJS;

public class ForgotPasswordPage extends LoginPage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    private static WebElement forgotPwdFieldOnForgotPwdScreen;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
    private static WebElement continueOnForgotBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Return to Sign In screen']")
    private static WebElement returnToSignInScreen;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Forgot your password?']")
    private static WebElement forgotPwdLink;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forgot password']")
    private static WebElement forgotPwdText;


    public ForgotPasswordPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public ForgotPasswordPage checkPresenceOfForgotPwdFieldText() {
        String fieldOnForgotPwdScreenText = forgotPwdFieldOnForgotPwdScreen.getText().trim();
        if (!fieldOnForgotPwdScreenText.isEmpty()) {
            if (fieldOnForgotPwdScreenText.equalsIgnoreCase("Enter your email")) {
                ExtentLogger.pass("Text 'Enter your email' is matched");
            } else {
                ExtentLogger.fail("Text 'Enter your email' is not matched");
            }
        } else {
            throw new RuntimeException("Forgot password field is not present");
        }
        return this;
    }


    public ForgotPasswordPage forgotPasswordPageTitle() {
        WaitHelpers.waitTime(5);
        if (forgotPwdText.isDisplayed()) {
            ExtentLogger.pass("Page title 'Forgot your password' is displayed");
        } else {
            ExtentLogger.fail("Page title 'Forgot your password' is not displayed");
        }
        return this;
    }



    public ForgotPasswordPage validateErrorOnInvalidForgotPwdField() {
        click(forgotPwdFieldOnForgotPwdScreen, "Forgot password");
        sendTextUsingJS("sfshfjkd");
        clickByCoordinates(529, 1134, 5);
        if (forgotPwdFieldOnForgotPwdScreen.isDisplayed()) {
            String errorMessage = forgotPwdFieldOnForgotPwdScreen.getText().trim();
            if (errorMessage.contains("Please enter a valid email address.")) {
                ExtentLogger.info("Error displayed - Please enter valid email address.");
                ExtentLogger.pass("Error displayed - Please enter valid email address.");
            } else {
                ExtentLogger.fail("no Error displayed - Please enter valid email address." + " Actual error was==>" + errorMessage);
            }
        } else {
            throw new RuntimeException("forgot password screen not displayed");
        }
        WaitHelpers.waitTime(10);
        return this;
    }

    public ForgotPasswordPage verifyEmailIdAccept50Char() {
        String data = "Myr98lgD0jPqTzqMhKm2JEItOk6YDxDJxaYigLbWHlYXbj4we";
        click(forgotPwdFieldOnForgotPwdScreen, "forgot password email");
        sendTextUsingJS(data);
        ExtentLogger.info("Entered test data");
        Assert.assertEquals(forgotPwdFieldOnForgotPwdScreen.getText().replace("Email: ", "").trim(), data);
        return this;
    }

    public ForgotPasswordPage enterEmailAndContinue(String email) {
        click(forgotPwdFieldOnForgotPwdScreen, "email");
        sendTextUsingJS(email);
        ExtentLogger.info("User enter valid Email Address");
        continueBtnState();
        click(continueOnForgotBtn, "continue");
        if (returnToSignInScreen.isDisplayed()) {
            ExtentLogger.pass("Email sent successfully");
            ExtentLogger.info("continue");
        }else{
            throw new RuntimeException("Email not sent successfully");
        }
        return this;
    }

    public void clickOnReturnToSignIn(){
        if (returnToSignInScreen.isDisplayed() && returnToSignInScreen.isEnabled()) {
            click(returnToSignInScreen,"returnToSignInScreen");
            if (forgotPwdLink.isDisplayed()) {
                ExtentLogger.pass("User navigated to signIn Screen successfully");
            }
        }else{
            ExtentLogger.fail("User could not navigate to signIn Screen");
        }
    }



    private ForgotPasswordPage continueBtnState(){
        if(continueOnForgotBtn.isDisplayed() && continueOnForgotBtn.isEnabled()){
            ExtentLogger.pass("Continue button displayed and enable");
        }else {
            ExtentLogger.fail("Continue button not displayed or enabled");
        }

        return this;
    }







}
