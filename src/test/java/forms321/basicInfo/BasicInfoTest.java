package forms321.basicInfo;

import forms321.base.BaseTest;
import org.testng.annotations.Test;
import pages.BasicInfoPage;

public class BasicInfoTest extends BaseTest{
    @Test(priority = 1)
    public void MiddleNameLengthTest(){
        BasicInfoPage basicInfoPage = new BasicInfoPage(driver);
        basicInfoPage.checkMiddleNameLength();
    }

    @Test(priority = 2)
    public void ClickAgreeButtonTest() {
        // Use the SignInCodePage object
        BasicInfoPage basicInfoPage = new BasicInfoPage(driver);

        // Navigate to the desired page
        basicInfoPage.clickAgreeButton();
    }
}