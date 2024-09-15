package forms321.employeementDashboard;

import forms321.base.BaseTest;
import forms321.base.ConfigLoader;
import org.testng.annotations.Test;
import pages.EmploymentDashboardPage;
import pages.SignInCodePage;

public class EmployeementDashboardTest extends BaseTest {
    @Test
    public void ClickAgreeButtonTest() {
        // Use the SignInCodePage object
        EmploymentDashboardPage employmentDashboardPage = new EmploymentDashboardPage(driver);

        // Navigate to the desired page
        employmentDashboardPage.clickAgreeButton();
    }
}
