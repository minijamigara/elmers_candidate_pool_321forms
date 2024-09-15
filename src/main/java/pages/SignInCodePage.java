package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInCodePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInCode = By.id("signInCode");
    private By verifyBtn = By.id("verifyBtn");

    public SignInCodePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SignInCodePage setOtpCode(String otpCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInCode)).sendKeys(otpCode);
        return this;  // Returning the current instance for method chaining
    }
    public SignInCodePage clickVerifyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn)).click();
        return new SignInCodePage(driver);
    }
}
