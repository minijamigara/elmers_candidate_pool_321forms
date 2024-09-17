package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UniformInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By shirtSize = By.id("sel_1_136571");

    //button
    private By btnContinue = By.id("btnContinue");

    public UniformInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    // Method to set the dropdown value
    public UniformInfoPage setShirt(String shirt) {
        WebElement dropdownElement = driver.findElement(shirtSize);
        Select shirtSizeSelect = new Select(dropdownElement);
        shirtSizeSelect.selectByVisibleText(shirt);  // You can also use selectByValue or selectByIndex
        return this;
    }

    // Method to get the currently selected value from the dropdown
    public String getSelectedShirtSize() {
        WebElement dropdownElement = driver.findElement(shirtSize);
        Select shirtSizeSelect = new Select(dropdownElement);
        return shirtSizeSelect.getFirstSelectedOption().getText();  // Retrieves the currently selected option's text
    }

    public UniformInfoPage clickContinueButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new UniformInfoPage(driver);
    }

}
