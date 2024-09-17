package forms321.basicInfo3;

import forms321.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicInfo2Page;
import pages.BasicInfo3Page;

public class BasicInfo3PageTest extends BaseTest {
    @Test(priority = 1)
    public void testSelectTestedDrugsYes() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Tested Drugs Yes"
        basicInfo3Page.selectTestedDrugsYes();

        // Verify the "Tested Drugs Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105611_1")).isSelected(), "Tested Drugs Yes radio button is not selected.");
    }

/*    @Test
    public void testSelectTestedDrugsNo() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Tested Drugs No"
        basicInfo3Page.selectTestedDrugsNo();

        // Verify the "Tested Drugs No" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105611_2")).isSelected(), "Tested Drugs No radio button is not selected.");
    }*/

    @Test(priority = 2)
    public void testSelectPositiveDrugsYes() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Positive Drugs Yes"
        basicInfo3Page.selectPositiveDrugsYes();

        // Verify the "Positive Drugs Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105612_1")).isSelected(), "Positive Drugs Yes radio button is not selected.");
    }

/*    @Test
    public void testSelectPositiveDrugsNo() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Positive Drugs No"
        basicInfo3Page.selectPositiveDrugsNo();

        // Verify the "Positive Drugs No" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105612_2")).isSelected(), "Positive Drugs No radio button is not selected.");
    }*/

    @Test(priority = 3)
    public void testSelectPositivePreDrugsYes() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Positive Pre Drugs Yes"
        basicInfo3Page.selectPositivePreDrugsYes();

        // Verify the "Positive Pre Drugs Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105613_1")).isSelected(), "Positive Pre Drugs Yes radio button is not selected.");
    }

/*    @Test
    public void testSelectPositivePreDrugsNo() {
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Select "Positive Pre Drugs No"
        basicInfo3Page.selectPositivePreDrugsNo();

        // Verify the "Positive Pre Drugs No" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_105613_2")).isSelected(), "Positive Pre Drugs No radio button is not selected.");
    }*/

    @Test(priority = 4)
    public void clickContinueButton() {
        // Use the SignInCodePage object
        BasicInfo3Page basicInfo3Page = new BasicInfo3Page(driver);

        // Navigate to the desired page
        basicInfo3Page.clickContinueButton();
    }
}
