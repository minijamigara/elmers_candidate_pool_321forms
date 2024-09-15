package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login321Page {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.id("txtusername");
    private By passwordField = By.id("pwdpassword");
    private By loginButton = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div/form/button");

    public Login321Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public Login321Page setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        return this;  // Returning the current instance for method chaining
    }

    public Login321Page setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;  // Returning the current instance for method chaining
    }

    public SignInCodePage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new SignInCodePage(driver);
    }
}
