package newHireData;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.NavigationPage;
import pages.NewHireDataPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewHireDataTest extends BaseTest {
    @Test
    public void testFileUpload(){
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

        NewHireDataPage newHireDataPage = new NewHireDataPage(driver);

        newHireDataPage.uploadFile("C:\\Users\\TUF\\Downloads\\industry.csv");

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Open a new tab
        driver.switchTo().newWindow(WindowType.TAB);

        // Switch to the new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Navigate to the same URL in the new tab
        driver.get(currentUrl);

        // Optional: Verify the navigation was successful
        assertEquals(driver.getCurrentUrl(), currentUrl);

    }
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
