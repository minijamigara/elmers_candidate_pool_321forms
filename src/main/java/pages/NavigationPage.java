package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By search_box = By.id("menuQuickSearch_menuQuickSearch");
    private By suggest_list = By.id("menuQuickSearchResultList");
    private By suggest_item = By.xpath("//ul[@id='menuQuickSearchResultList']/li[@id='autoComplete_result_0']");
    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateToNewHireDataUpload() {
        // Locate the search box and type the query
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(search_box)); // Use the correct locator for your search box
        searchBox.sendKeys("New Hire Data Upload");

        // Wait for the suggestions to be visible
        WebElement suggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(suggest_list));

        // Locate the specific suggestion item
        WebElement suggestionItem = wait.until(ExpectedConditions.elementToBeClickable(suggest_item));

        // Click on the suggestion
        suggestionItem.click();
    }
}
