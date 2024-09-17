package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W4Page {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By NonResidentYes = By.id("ch_1_21876_1");
    private By NonResidentNo = By.id("ch_1_21876_2");
    private By LastNameDifYes = By.id("ch_1_458_1");
    private By LastNameDifNo = By.id("ch_1_458_2");
    private By ExemptYes = By.id("ch_1_154114_1_389903");
    private By ExemptNo = By.id("ch_1_154114_2_389904");
    private By Single = By.id("ch_1_154116_1");
    private By Married = By.id("ch_1_154116_2");
    private By HeadOfHouse = By.id("ch_1_154116_3");
    private By MoreThan1JobYes = By.id("ch_1_65216_1_134376");
    private By MoreThan1JobNo = By.id("ch_1_65216_2_134377");
    private By ChildrenNo = By.id("qid_1_65218");
    private By DependentNo = By.id("qid_1_65219");
    private By TotForDependent = By.id("qid_1_65220");
    private By OtherIncome = By.id("qid_1_65221");
    private By Deductions = By.id("qid_1_65222");
    private By ExtraWithHolding = By.id("qid_1_65223");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public W4Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public W4Page selectNonResidentYes() {
        WebElement NonResidentYesRadio = driver.findElement(NonResidentYes);
        if (!NonResidentYesRadio.isSelected()) {
            NonResidentYesRadio.click();
        }
        return this;
    }

    public W4Page selectLastNameDifYes() {
        WebElement LastNameDifYesRadio = driver.findElement(LastNameDifYes);
        if (!LastNameDifYesRadio.isSelected()) {
            LastNameDifYesRadio.click();
        }
        return this;
    }

    public W4Page selectExemptNo() {
        WebElement ExemptNoRadio = driver.findElement(ExemptNo);
        if (!ExemptNoRadio.isSelected()) {
            ExemptNoRadio.click();
        }
        return this;
    }

    public W4Page selectSingle() {
        WebElement SingleRadio = driver.findElement(Single);
        if (!SingleRadio.isSelected()) {
            SingleRadio.click();
        }
        return this;
    }

    public W4Page selectMoreThan1JobNo() {
        WebElement MoreThan1JobNoRadio = driver.findElement(MoreThan1JobNo);
        if (!MoreThan1JobNoRadio.isSelected()) {
            MoreThan1JobNoRadio.click();
        }
        return this;
    }

    // Method to input ChildrenNo into both fields
    public W4Page enterChildrenNo(String children_no) {
        WebElement ChildrenNoField = driver.findElement(ChildrenNo);

        ChildrenNoField.clear();
        ChildrenNoField.sendKeys(children_no);

        return this;
    }

    // Method to input DependentNo into both fields
    public W4Page enterDependentNo(String dependent_no) {
        WebElement DependentNoField = driver.findElement(DependentNo);

        DependentNoField.clear();
        DependentNoField.sendKeys(dependent_no);

        return this;
    }

    // Method to input TotForDependent into both fields
    public W4Page enterTotForDependent(String tot_dependent) {
        WebElement TotForDependentField = driver.findElement(TotForDependent);

        TotForDependentField.clear();
        TotForDependentField.sendKeys(tot_dependent);

        return this;
    }

    // Method to input OtherIncome into both fields
    public W4Page enterOtherIncome(String other_income) {
        WebElement OtherIncomeField = driver.findElement(OtherIncome);

        OtherIncomeField.clear();
        OtherIncomeField.sendKeys(other_income);

        return this;
    }

    // Method to input Deductions into both fields
    public W4Page enterDeductions(String deductions) {
        WebElement DeductionsField = driver.findElement(Deductions);

        DeductionsField.clear();
        DeductionsField.sendKeys(deductions);

        return this;
    }

    // Method to input ExtraWithHolding into both fields
    public W4Page enterExtraWithHolding(String extra_with_holdings) {
        WebElement ExtraWithHoldingField = driver.findElement(ExtraWithHolding);

        ExtraWithHoldingField.clear();
        ExtraWithHoldingField.sendKeys(extra_with_holdings);

        return this;
    }

    public W4Page clickContinueButton() {
        driver.findElement(continueBtn).click();
        return this;
    }

}
