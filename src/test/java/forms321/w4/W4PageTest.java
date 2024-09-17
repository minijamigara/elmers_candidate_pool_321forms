package forms321.w4;

import forms321.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicInfo2Page;
import pages.BasicInfo3Page;
import pages.W4Page;

public class W4PageTest extends BaseTest {
    @Test(priority = 1)
    public void testSelectNonResidentYes() {
        W4Page w4Page = new W4Page(driver);

        // Select "Non Resident Yes"
        w4Page.selectNonResidentYes();

        // Verify the "Non Resident Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_21876_1")).isSelected(), "Non Resident Yes radio button is not selected.");
    }

    @Test(priority = 2)
    public void testSelectLastNameDifYes() {
        W4Page w4Page = new W4Page(driver);

        // Select "Last Name Dif Yes"
        w4Page.selectLastNameDifYes();

        // Verify the "Last Name Dif Yes" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_458_1")).isSelected(), "Last Name Dif Yes radio button is not selected.");
    }

    @Test(priority = 3)
    public void testSelectExemptNo() {
        W4Page w4Page = new W4Page(driver);

        // Select "Exempt No Yes"
        w4Page.selectExemptNo();

        // Verify the "Exempt No" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_154114_2_389904")).isSelected(), "Exempt No radio button is not selected.");
    }

    @Test(priority = 4)
    public void testSelectSingle() {
        W4Page w4Page = new W4Page(driver);

        // Select "Single"
        w4Page.selectSingle();

        // Verify the "Single" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_154116_1")).isSelected(), "Single radio button is not selected.");
    }

    @Test(priority = 5)
    public void testSelectMoreThan1JobNo() {
        W4Page w4Page = new W4Page(driver);

        // Select "Single"
        w4Page.selectMoreThan1JobNo();

        // Verify the "More Than 1 Job No" radio button is selected
        Assert.assertTrue(driver.findElement(By.id("ch_1_65216_2_134377")).isSelected(), "More Than 1 Job No radio button is not selected.");
    }

    @Test(priority = 6)
    public void testChildrenNo() {
        W4Page w4Page = new W4Page(driver);

        String children_no_val = "3";

        w4Page.enterChildrenNo(children_no_val);
    }

    @Test(priority = 7)
    public void testDependentNo() {
        W4Page w4Page = new W4Page(driver);

        String dependent_val = "2";

        w4Page.enterDependentNo(dependent_val);
    }

    @Test(priority = 8)
    public void testTotForDependent() {
        W4Page w4Page = new W4Page(driver);

        String tot_dependent_val = "5";

        w4Page.enterTotForDependent(tot_dependent_val);
    }

    @Test(priority = 9)
    public void testOtherIncome() {
        W4Page w4Page = new W4Page(driver);

        String other_income_val = "10000";

        w4Page.enterOtherIncome(other_income_val);
    }

    @Test(priority = 10)
    public void testDeductions() {
        W4Page w4Page = new W4Page(driver);

        String deduction_val = "2000";

        w4Page.enterDeductions(deduction_val);
    }

    @Test(priority = 11)
    public void testExtraWithHolding() {
        W4Page w4Page = new W4Page(driver);

        String extra_with_holdings_val = "5000";

        w4Page.enterExtraWithHolding(extra_with_holdings_val);
    }

    @Test(priority = 12)
    public void clickContinueButton() {
        // Use the SignInCodePage object
        W4Page w4Page = new W4Page(driver);

        // Navigate to the desired page
        w4Page.clickContinueButton();
    }

}


