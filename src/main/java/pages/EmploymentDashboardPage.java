package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmploymentDashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By agreeBtn = By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[3]/span[1]/form/input[1]");

    public EmploymentDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public EmploymentDashboardPage clickAgreeButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(agreeBtn)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(agreeBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new EmploymentDashboardPage(driver);
    }
}
