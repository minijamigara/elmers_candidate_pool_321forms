package navigation;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.NavigationPage;

import java.time.Duration;

public class NavigationTest extends BaseTest {
    @Test
    public void testNavigateToNewHireDataUpload() {
        // Assuming you are starting from the DashboardPage
        loginPage.setUsername("_ohrmSysAdmin_")
                .setPassword("admin");
        DashboardPage dashboardPage = loginPage.clickLoginButton();

        // Wait until the DashboardPage is fully loaded
        waitForPageToLoad();

        // Create an instance of NavigationPage
        NavigationPage navigationPage = new NavigationPage(driver);

        // Navigate to the desired page
        navigationPage.navigateToNewHireDataUpload();

        // Add assertions or further actions after navigation
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmb1-lts-atom.orangehrm.com/client/#/pim/applicant_pool-csv");  // Replace with the actual URL
    }

        // Method to wait for the page to fully load
        private void waitForPageToLoad() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Wait for the document to be ready
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return js.executeScript("return document.readyState").equals("complete");
                }
            };
            wait.until(pageLoadCondition);
        }


}
