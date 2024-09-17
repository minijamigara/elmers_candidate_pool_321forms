package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsExecutionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Executable task
    private By create321AccountTask = By.xpath("/html/body/div[1]/div[2]/section/div/div[1]/div/div/form/div[3]/table/tbody/tr[12]/td[1]/a");

    // Modal
    private By ExecuteButton = By.id("saveTaskType");
    private By modal = By.cssSelector("#taskExecutionModal");

    // Constructor
    public FormsExecutionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToCreate321Task() {
        // Scroll to the applicant pool task element
        WebElement create_321_account_pool_task = wait.until(ExpectedConditions.presenceOfElementLocated(create321AccountTask));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", create_321_account_pool_task);

        // Wait for the element to be visible and clickable
        wait.until(ExpectedConditions.visibilityOf(create_321_account_pool_task));
        wait.until(ExpectedConditions.elementToBeClickable(create_321_account_pool_task));

        // Click on the applicant pool task element
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", create_321_account_pool_task);

        // Wait for the modal to be fully loaded and visible
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        // Focus on the modal using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", modalElement);

        // Focus on the execute button
        WebElement execute_button = wait.until(ExpectedConditions.elementToBeClickable(ExecuteButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", execute_button);
    }
}
