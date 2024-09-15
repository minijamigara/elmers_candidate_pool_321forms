package candidatePool.navigation;

import candidatePool.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationPage;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigateToNewHireDataUpload() {
        NavigationPage navigationPage = new NavigationPage(driver);

        // Navigate to the desired page
        navigationPage.navigateToNewHireDataUpload();

        // Add assertions or further actions after navigation
        Assert.assertEquals(driver.getCurrentUrl(), "https://elmb1-lts-atom.orangehrm.com/client/#/pim/applicant_pool-csv");  // Replace with the actual URL
    }
}
