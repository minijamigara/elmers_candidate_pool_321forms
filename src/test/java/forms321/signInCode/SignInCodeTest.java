package forms321.signInCode;

import forms321.base.BaseTest;
import forms321.base.ConfigLoader;
import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.SignInCodePage;

public class SignInCodeTest extends BaseTest {
    @Test
    public void successfulSignInCodeTest() {
        // Fetch the username and password from the config file
        ConfigLoader config = new ConfigLoader();
        String otp = config.getOTP();

        // Use the SignInCodePage object
        SignInCodePage signInCodePage = new SignInCodePage(driver);

        // Navigate to the desired page
        signInCodePage.setOtpCode(otp);
        signInCodePage.clickVerifyButton();
    }

}
