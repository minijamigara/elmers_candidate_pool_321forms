package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicInfo2Page {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By genderMaleRadio = By.id("ch_1_23_1");
    private By genderFemaleRadio = By.id("ch_1_23_2");
    private By PrefferedName = By.id("qid_1_9721");
    private By SSN = By.id("qid_1_51");
    private By ConfirmSSN = By.id("q_1_51_confirm");
    private By DLNumber = By.id("qid_1_874");
    private By DLIssueState = By.id("qid_1_875");
    private By DLExpireDate = By.id("qid_1_1391");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasicInfo2Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    // Method to check if the Male or Female radio button is selected
    public boolean isGenderSelected(String gender) {
        WebElement genderRadioBtn;
        if (gender.equalsIgnoreCase("male")) {
            genderRadioBtn = driver.findElement(genderMaleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            genderRadioBtn = driver.findElement(genderFemaleRadio);
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }

        return genderRadioBtn.isSelected();
    }

    public String checkNullPrefferedName(){

        String PrefferedNameVal = (String) js.executeScript("return document.getElementById('qid_1_9721').value;");
        if (PrefferedNameVal == null || PrefferedNameVal.trim().isEmpty()) {
            System.out.println("Preffered name is empty.");
        } else {
            System.out.println("Preffered name: " + PrefferedNameVal);
        }
        return PrefferedNameVal;
    }

    // Method to input SSN into both fields
    public BasicInfo2Page enterSSN(String ssnValue) {
        WebElement ssnField = driver.findElement(SSN);
        WebElement confirmSSNField = driver.findElement(ConfirmSSN);

        ssnField.clear();
        ssnField.sendKeys(ssnValue);

        confirmSSNField.clear();
        confirmSSNField.sendKeys(ssnValue);

        return this;
    }
    // Method to check if SSN and ConfirmSSN are identical
    public boolean areSSNAndConfirmSSNIdentical() {
        String ssnValue = driver.findElement(SSN).getAttribute("value");
        String confirmSSNValue = driver.findElement(ConfirmSSN).getAttribute("value");

        return ssnValue.equals(confirmSSNValue);
    }

    public String checkNullDLNumber(){

        String DLNumberVal = (String) js.executeScript("return document.getElementById('qid_1_874').value;");
        if (DLNumberVal == null || DLNumberVal.trim().isEmpty()) {
            System.out.println("DL number is empty.");
        } else {
            System.out.println("DL number: " + DLNumberVal);
        }
        return DLNumberVal;
    }

    public String checkNullLicenseIssueState(){
        WebElement dropdownElement = driver.findElement(DLIssueState);
        Select dropdown = new Select(dropdownElement);

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();

        if (selectedValue.equals("Select") || selectedValue.trim().isEmpty()) {
            System.out.println("No valid option is selected. Default option ('Select') is still selected.");
        } else {
            System.out.println("Selected option: " + selectedValue);
        }
        return selectedValue;
    }

    public boolean isDLExpireDateSelected() {
        WebElement dlExpireDateField = driver.findElement(DLExpireDate);
        String expireDateValue = dlExpireDateField.getAttribute("value");

        // If the value is null or empty, the date is not selected
        return expireDateValue != null && !expireDateValue.trim().isEmpty();
    }

    public GeneralInfoPage clickContinueButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new GeneralInfoPage(driver);
    }

}
