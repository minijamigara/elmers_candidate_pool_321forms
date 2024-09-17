package forms321.basicInfo2;

import forms321.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicInfo2Page;
import pages.GeneralInfoPage;

public class BasicInfo2PageTest extends BaseTest {

    @Test(priority = 1)
    public void testGenderRadioButtonSelection() {
        BasicInfo2Page basicInfo2Page = new BasicInfo2Page(driver);

        // Check if the Male radio button is selected
        boolean isMaleSelected = basicInfo2Page.isGenderSelected("male");
        Assert.assertTrue(isMaleSelected, "The Male gender radio button is not selected.");

        // Alternatively, check if the Female radio button is selected
        boolean isFemaleSelected = basicInfo2Page.isGenderSelected("female");
        Assert.assertFalse(isFemaleSelected, "The Female gender radio button is selected when it shouldn't be.");
    }

    @Test(priority = 2)
    public void checkNullPrefferedNameTest(){
        BasicInfo2Page basicInfo2Page = new BasicInfo2Page(driver);

        Assert.assertTrue(basicInfo2Page.checkNullPrefferedName() == null || basicInfo2Page.checkNullPrefferedName().trim().isEmpty(),
                "Prefferred is not null or empty. Value: " + basicInfo2Page.checkNullPrefferedName());
    }

    @Test(priority = 3)
    public void testSSNAndConfirmSSNAreIdentical() {
        BasicInfo2Page basicInfo2Page = new BasicInfo2Page(driver);

        // Define an SSN number to be entered
        String ssnValue = "111223333";

        // Enter SSN and Confirm SSN
        basicInfo2Page.enterSSN(ssnValue);

        // Verify both SSN and Confirm SSN are identical
        boolean areIdentical = basicInfo2Page.areSSNAndConfirmSSNIdentical();
        Assert.assertTrue(areIdentical, "SSN and Confirm SSN values are not identical.");
    }

    @Test(priority = 4)
    public void checkNullDLNumberTest(){
        BasicInfo2Page basicInfo2Page = new BasicInfo2Page(driver);

        Assert.assertTrue(basicInfo2Page.checkNullDLNumber() == null || basicInfo2Page.checkNullDLNumber().trim().isEmpty(),
                "DL Number is not null or empty. Value: " + basicInfo2Page.checkNullDLNumber());
    }

    @Test(priority = 5)
    public void checkNullDLIssueStateTest(){
        BasicInfo2Page basicInfo2Page = new BasicInfo2Page(driver);

        Assert.assertTrue(basicInfo2Page.checkNullLicenseIssueState() == null || basicInfo2Page.checkNullLicenseIssueState().trim().isEmpty(),
                "DL License Issue State is not null or empty. Value: " + basicInfo2Page.checkNullLicenseIssueState());
    }


}
