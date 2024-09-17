package forms321.generalInfo;

import forms321.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GeneralInfoPage;

public class GeneralInfoPageTest extends BaseTest {
    @Test(priority = 1)
    public void checkNullHouseAddressTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullHouseAddress() == null || generalInfo.checkNullHouseAddress().trim().isEmpty(),
                "Household Street Address is not null or empty. Value: " + generalInfo.checkNullHouseAddress());
    }

    @Test(priority = 2)
    public void checkNullApartmentNoTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullApartmentNo() == null || generalInfo.checkNullApartmentNo().trim().isEmpty(),
                "Apartment No is not null or empty. Value: " + generalInfo.checkNullApartmentNo());
    }

    @Test(priority = 3)
    public void checkCityTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullCity() == null || generalInfo.checkNullCity().trim().isEmpty(),
                "City is not null or empty. Value: " + generalInfo.checkNullCity());
    }

    @Test(priority = 4)
    public void testCheckNullCountry() {
        GeneralInfoPage generalInfoPage = new GeneralInfoPage(driver);

        // Get the initial value of the country field
        String initialCountryVal = generalInfoPage.getCountryValue();

        // Call the method to check and set the country value
        generalInfoPage.checkNullCountry();

        // Get the updated value of the country field
        String updatedCountryVal = generalInfoPage.getCountryValue();

        // If the initial value was empty, it should now be "USA"
        if (initialCountryVal == null || initialCountryVal.trim().isEmpty()) {
            Assert.assertEquals(updatedCountryVal, "USA", "Country field was not updated to 'USA'.");
        } else {
            // If the initial value was not empty, the value should remain the same
            Assert.assertEquals(updatedCountryVal, initialCountryVal, "Country field value was changed unexpectedly.");
        }
    }

    @Test(priority = 5)
    public void checkNullStateAbbreviationTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullStateAbbreviation() == null || generalInfo.checkNullStateAbbreviation().trim().isEmpty(),
                "State Abbreviation is not null or empty. Value: " + generalInfo.checkNullStateAbbreviation());
    }

    @Test(priority = 6)
    public void processZipCodeTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        generalInfo.processZipCode();
    }

    @Test(priority = 7)
    public void checkNullCellularTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullCellular() == null || generalInfo.checkNullCellular().trim().isEmpty(),
                "Cellular is not null or empty. Value: " + generalInfo.checkNullCellular());
    }

    @Test(priority = 8)
    public void checkNullPersonalEmailTest(){
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        Assert.assertTrue(generalInfo.checkNullPersonalEmail() == null || generalInfo.checkNullPersonalEmail().trim().isEmpty(),
                "Personal email is not null or empty. Value: " + generalInfo.checkNullPersonalEmail());
    }

    @Test(priority = 9)
    public void clickContinueButtonTest() {
        // Use the SignInCodePage object
        GeneralInfoPage generalInfo = new GeneralInfoPage(driver);

        // Navigate to the desired page
        generalInfo.clickContinueButton();
    }
}
