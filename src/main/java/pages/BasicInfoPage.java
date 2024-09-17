package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By firstName = By.id("qid_1_204");
    private By middleNameL = By.id("qid_1_59");
    private By lastName = By.id("qid_1_21");
    private By dob = By.id("qid_1_22");

    //button
    private By basicInfoSave = By.id("btnSubmit2");

    public BasicInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }
    public BasicInfoPage checkMiddleNameLength(){
        WebElement middleName = driver.findElement(middleNameL);
        String MiddleNameValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", middleName);
        if (MiddleNameValue.length() > 1) {
            // Keep only the first character
            MiddleNameValue = String.valueOf(MiddleNameValue.charAt(0));
            middleName.clear();
            middleName.sendKeys(MiddleNameValue);
            System.out.println("Given Middle Name Length is Longer Than Accepted Length");
        }
        return new BasicInfoPage(driver);
    }
    public BasicInfoPage clickAgreeButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(basicInfoSave));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new BasicInfoPage(driver);
    }
}
