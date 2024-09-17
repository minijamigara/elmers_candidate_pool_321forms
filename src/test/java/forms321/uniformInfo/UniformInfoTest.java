package forms321.uniformInfo;

import forms321.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GeneralInfoPage;
import pages.UniformInfoPage;

public class UniformInfoTest extends BaseTest {

    @Test(priority = 1)
    public void testSetCountryDropdown() {
        UniformInfoPage uniformInfoPage = new UniformInfoPage(driver);

        // Set the country dropdown value to "L-large"
        uniformInfoPage.setShirt("L-large");

        /*
        S-small
        M-medium
        L-large
        XL-extra-large
        2XL-two extra-large
        3XL-3 extra-large
        4XL-four extra-large
        5XL-5 extra-large
         */

        // Verify that the dropdown is now set to "L-large"
        String selectedShirt = uniformInfoPage.getSelectedShirtSize();
        Assert.assertEquals(selectedShirt, "L-large", "Shirt dropdown value is not set to 'L-large'.");
    }

    @Test(priority = 2)
    public void clickContinueButtonTest() {
        // Use the SignInCodePage object
        UniformInfoPage uniformInfoPage = new UniformInfoPage(driver);

        // Navigate to the desired page
        uniformInfoPage.clickContinueButton();
    }
}
