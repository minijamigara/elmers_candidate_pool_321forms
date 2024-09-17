package forms321.i9;

import forms321.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicInfo3Page;
import pages.I9Page;

public class I9PageTest extends BaseTest {

    @Test(priority = 1)
    public void testSelectCitizen() {
        I9Page i9Page = new I9Page(driver);

        // Select "Tested Drugs Yes"
        i9Page.selectCitizen();

        // Verify the "Tested Drugs Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_4300_1_361834")).isSelected(), "Citizen radio button is not selected.");
    }

    @Test(priority = 2)
    public void testSelectMyself() {
        I9Page i9Page = new I9Page(driver);

        // Select "Tested Drugs Yes"
        i9Page.selectMyself();

        // Verify the "Tested Drugs Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_4306_1_361947")).isSelected(), "Myself radio button is not selected.");
    }

    @Test(priority = 3)
    public void clickContinueButton() {
        // Use the SignInCodePage object
        I9Page i9Page = new I9Page(driver);

        // Navigate to the desired page
        i9Page.clickContinueButton();
    }

}
