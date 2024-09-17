package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MichiganWithholdingInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By PersonalDependentNo = By.id("qid_1_2072");
    private By AdditionalAmount = By.id("qid_1_2073");
    private By Exemption = By.id("ch_1_2074_1_226760");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public MichiganWithholdingInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public MichiganWithholdingInformationPage enterPersonalDependentNo(String dependent_no) {
        WebElement PersonalDependentNoField = driver.findElement(PersonalDependentNo);

        PersonalDependentNoField.clear();
        PersonalDependentNoField.sendKeys(dependent_no);

        return this;
    }
    public MichiganWithholdingInformationPage enterAdditionalAmount (String additional_amount) {
        WebElement AdditionalAmountField = driver.findElement(AdditionalAmount);

        AdditionalAmountField.clear();
        AdditionalAmountField.sendKeys(additional_amount);

        return this;
    }

    public MichiganWithholdingInformationPage selectExemption() {
        WebElement ExemptionRadio = driver.findElement(Exemption);
        if (!ExemptionRadio.isSelected()) {
            ExemptionRadio.click();
        }
        return this;
    }

    public MichiganWithholdingInformationPage clickContinueButton() {
        driver.findElement(continueBtn).click();
        return this;
    }
}
