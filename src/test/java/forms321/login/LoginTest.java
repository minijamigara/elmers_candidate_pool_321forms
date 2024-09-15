package forms321.login;

import forms321.base.BaseTest;
import forms321.base.ConfigLoader;
import org.testng.annotations.Test;
import pages.SignInCodePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        // Fetch the username and password from the config file
        ConfigLoader config = new ConfigLoader();
        String username = config.getUsername();
        String password = config.getPassword();

        // Use the LoginPage object from BaseTest to perform login
        login321Page.setUsername(username);
        login321Page.setPassword(password);
        SignInCodePage dashboard321Page = login321Page.clickLoginButton();
    }
}
