package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicantPoolExecution {
    private WebDriver driver;
    private WebDriverWait wait;

    // Search
    private By search_box = By.id("menuQuickSearch_menuQuickSearch");
    private By suggest_list = By.id("menuQuickSearchResultList");
    private By suggest_item = By.xpath("//ul[@id='menuQuickSearchResultList']/li[@id='autoComplete_result_0']");

    // Executable task
    private By applicantPoolTask = By.xpath("/html/body/div[1]/div[2]/section/div/div[1]/div/div/form/div[3]/table/tbody/tr[21]/td[1]/a");

    // Modal
    private By ExecuteButton = By.id("saveTaskType");
    private By modal = By.cssSelector("#taskExecutionModal");

    // Constructor
    public ApplicantPoolExecution(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToExecutableTasks() {
        // Locate the search box and type the query
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(search_box));
        searchBox.sendKeys("Executable Tasks");

        // Wait for the suggestions to be visible and select the suggestion item
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggest_list));
        WebElement suggestionItem = wait.until(ExpectedConditions.elementToBeClickable(suggest_item));
        suggestionItem.click();

        // Switch to the frame containing the tasks
        driver.switchTo().frame("noncoreIframe");

        // Scroll to the applicant pool task element
        WebElement applicant_pool_task = wait.until(ExpectedConditions.presenceOfElementLocated(applicantPoolTask));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applicant_pool_task);

        // Wait for the element to be visible and clickable
        wait.until(ExpectedConditions.visibilityOf(applicant_pool_task));
        wait.until(ExpectedConditions.elementToBeClickable(applicant_pool_task));

        // Click on the applicant pool task element
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applicant_pool_task);

        // Wait for the modal to be fully loaded and visible
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

        // Focus on the modal using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", modalElement);

        // Focus on the execute button
        WebElement execute_button = wait.until(ExpectedConditions.elementToBeClickable(ExecuteButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", execute_button);
    }
}
