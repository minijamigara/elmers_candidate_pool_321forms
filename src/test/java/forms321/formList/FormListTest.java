package forms321.formList;

import forms321.base.BaseTest;
import forms321.base.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormListPage;
import java.util.Arrays;
import java.util.List;

public class FormListTest extends BaseTest {
    @Test(priority = 1)
    public void VerifyFormList() {
        // Retrieve the array from the config file
        String[] formsArray = ConfigLoader.getArrayProperty("forms");

        // Convert the array to a list for easier comparison
        List<String> expectedFormsList = Arrays.asList(formsArray);

        // Capture the form list from the web page
        FormListPage formListPage = new FormListPage(driver);
        List<String> actualFormsList = formListPage.getFormListFromPage();

        // Compare the two lists
        Assert.assertEquals(actualFormsList, expectedFormsList, "The form lists do not match!");
    }

    @Test(priority = 2)
    public void ClickAgreeButtonTest() {
        // Use the SignInCodePage object
        FormListPage formListPage = new FormListPage(driver);

        // Navigate to the desired page
        formListPage.clickContinueButton();
    }

}
