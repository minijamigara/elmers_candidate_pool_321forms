package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FormListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By continueBtn = By.id("btnContinue");
    // Use a generic XPath to capture all <strong> elements within the list items
    private By formElements = By.xpath("/html/body/div[2]/div[1]/div/div/div/div/form/div[2]/div/div[2]/ul/li/div/div/strong");

    public FormListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    // Method to get the list of form names from the web page
    public List<String> getFormListFromPage() {
        List<WebElement> elements = driver.findElements(formElements);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public FormListPage clickContinueButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new FormListPage(driver);
    }
}
