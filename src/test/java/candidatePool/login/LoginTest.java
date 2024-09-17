package candidatePool.login;

import candidatePool.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        loginPage.setUsername("_ohrmSysAdmin_")
                .setPassword("admin@OHRM123");

        DashboardPage dashboardPage = loginPage.clickLoginButton();

        // Verify that the user is redirected to the correct dashboard URL after login
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmmbl-lts-atom.orangehrm.com/client/#/dashboard");
    }
}
