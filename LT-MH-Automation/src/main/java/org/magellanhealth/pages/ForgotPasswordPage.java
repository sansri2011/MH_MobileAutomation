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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forgot password']")
    private static WebElement forgotPwdText;


    public ForgotPasswordPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    public ForgotPasswordPage chedkPresenceOfForgotPwdFieldText() {
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
        if (forgotPwdText.isDisplayed()) {
            ExtentLogger.pass("Text 'Forgot your password' displayed");
        } else {
            ExtentLogger.fail("Text 'Forgot your password' not displayed");
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
        ExtentLogger.info("Entered email");
        click(continueOnForgotBtn, "continue");
        if (returnToSignInScreen.isDisplayed()) {
            ExtentLogger.info("continue");
            ExtentLogger.pass("Email sent successfully");
        }else{
            throw new RuntimeException("Email not sent successfully");
        }
        return this;
    }

}
