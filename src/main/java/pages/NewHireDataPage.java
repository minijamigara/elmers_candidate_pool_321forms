package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewHireDataPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By addButton = By.id("add-sub-project-btn");
    private By fileDescription = By.id("csvFileName");
    private By fileUploadButton = By.id("attachmentFile");
    private By modalSaveButton = By.id("modal-save-button");
    private By modal = By.cssSelector("#modal-holder > div > div");

    // Constructor
    public NewHireDataPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Method to upload a CSV file
    public void uploadFile(String absolutePathOfFile) {
        // Click the add button
        WebElement add_button = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        add_button.click();

        // Wait for the modal to be fully loaded and visible
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        // Focus on the modal using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", modalElement);

        // Focus on the file upload button
        WebElement uploadButton = driver.findElement(fileUploadButton);
        WebElement overlayingElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return document.elementFromPoint(arguments[0].getBoundingClientRect().left + window.pageXOffset, arguments[0].getBoundingClientRect().top + window.pageYOffset);",
                uploadButton);
        System.out.println("Overlaying element: " + overlayingElement.getTagName());


        // Use JavaScript to click on the upload button and upload the file
        uploadButton.sendKeys(absolutePathOfFile);

        // Enter the file description
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(fileDescription));
        descriptionField.sendKeys("Test");

        // Click the save button in the modal
        csvUpload();
    }

    // Method to click the modal save button
    private void csvUpload() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(modalSaveButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", saveButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
    }
}
