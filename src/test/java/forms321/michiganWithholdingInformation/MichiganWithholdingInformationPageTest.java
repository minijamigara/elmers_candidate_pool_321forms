package forms321.michiganWithholdingInformation;

import forms321.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MichiganWithholdingInformationPage;

public class MichiganWithholdingInformationPageTest extends BaseTest {
    @Test(priority = 1)
    public void testPersonalDependentNo() {
        MichiganWithholdingInformationPage michiganWithholdingInformationPage = new MichiganWithholdingInformationPage(driver);

        String dependent_val = "400";

        michiganWithholdingInformationPage.enterPersonalDependentNo(dependent_val);
    }

    @Test(priority = 2)
    public void testAdditionalAmount() {
        MichiganWithholdingInformationPage michiganWithholdingInformationPage = new MichiganWithholdingInformationPage(driver);

        String additional_val = "100";

        michiganWithholdingInformationPage.enterPersonalDependentNo(additional_val);
    }

    @Test(priority = 3)
    public void testExemption() {
        MichiganWithholdingInformationPage michiganWithholdingInformationPage = new MichiganWithholdingInformationPage(driver);

        michiganWithholdingInformationPage.selectExemption();

        Assert.assertTrue(driver.findElement(By.id("ch_1_2074_1_226760")).isSelected(), "Exemption radio button is not selected.");
    }

    @Test(priority = 4)
    public void clickContinueButton() {
        // Use the SignInCodePage object
        MichiganWithholdingInformationPage michiganWithholdingInformationPage = new MichiganWithholdingInformationPage(driver);

        // Navigate to the desired page
        michiganWithholdingInformationPage.clickContinueButton();
    }
}
