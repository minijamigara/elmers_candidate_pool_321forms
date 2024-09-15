package candidatePool.newHireData;

import candidatePool.base.BaseTest;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import pages.NewHireDataPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class NewHireDataTest extends BaseTest {
    @Test
    public void testSuccessfulFileUpload(){
        NewHireDataPage newHireDataPage = new NewHireDataPage(driver);

        newHireDataPage.uploadFile("/home/administrator/Downloads/New Hire.csv");

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
}
