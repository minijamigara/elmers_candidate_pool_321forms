package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicInfo3Page {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By testedDrugsYes = By.id("ch_1_105611_1");
    private By testedDrugsNo = By.id("ch_1_105611_2");
    private By positiveDrugsYes = By.id("ch_1_105612_1");
    private By positiveDrugsNo = By.id("ch_1_105612_2");
    private By positivePreDrugsYes = By.id("ch_1_105613_1");
    private By positivePreDrugsNo = By.id("ch_1_105613_2");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasicInfo3Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    // Method to select the "Tested Drugs Yes" radio button
    public BasicInfo3Page selectTestedDrugsYes() {
        WebElement testedDrugsYesRadio = driver.findElement(testedDrugsYes);
        if (!testedDrugsYesRadio.isSelected()) {
            testedDrugsYesRadio.click();
        }
        return this;
    }

    // Method to select the "Tested Drugs No" radio button
    public BasicInfo3Page selectTestedDrugsNo() {
        WebElement testedDrugsNoRadio = driver.findElement(testedDrugsNo);
        if (!testedDrugsNoRadio.isSelected()) {
            testedDrugsNoRadio.click();
        }
        return this;
    }

    // Method to select the "Positive Drugs Yes" radio button
    public BasicInfo3Page selectPositiveDrugsYes() {
        WebElement positiveDrugsYesRadio = driver.findElement(positiveDrugsYes);
        if (!positiveDrugsYesRadio.isSelected()) {
            positiveDrugsYesRadio.click();
        }
        return this;
    }

    // Method to select the "Positive Drugs No" radio button
    public BasicInfo3Page selectPositiveDrugsNo() {
        WebElement positiveDrugsNoRadio = driver.findElement(positiveDrugsNo);
        if (!positiveDrugsNoRadio.isSelected()) {
            positiveDrugsNoRadio.click();
        }
        return this;
    }

    // Method to select the "Positive Pre Drugs Yes" radio button
    public BasicInfo3Page selectPositivePreDrugsYes() {
        WebElement positivePreDrugsYesRadio = driver.findElement(positivePreDrugsYes);
        if (!positivePreDrugsYesRadio.isSelected()) {
            positivePreDrugsYesRadio.click();
        }
        return this;
    }

    // Method to select the "Positive Pre Drugs No" radio button
    public BasicInfo3Page selectPositivePreDrugsNo() {
        WebElement positivePreDrugsNoRadio = driver.findElement(positivePreDrugsNo);
        if (!positivePreDrugsNoRadio.isSelected()) {
            positivePreDrugsNoRadio.click();
        }
        return this;
    }

    // Optional method to click the continue button
    public BasicInfo3Page clickContinueButton() {
        driver.findElement(continueBtn).click();
        return this;
    }


}
