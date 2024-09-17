package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class I9Page {
    private WebDriver driver;
    private WebDriverWait wait;

    //input fields
    private By citizen = By.id("ch_1_4300_1_361834");
    private By myself = By.id("ch_1_4306_1_361947");

    //button
    private By continueBtn = By.id("btnContinue");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public I9Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a default wait time of 10 seconds
    }

    public I9Page selectCitizen() {
        WebElement citizenRadio = driver.findElement(citizen);
        if (!citizenRadio.isSelected()) {
            citizenRadio.click();
        }
        return this;
    }
    public I9Page selectMyself() {
        WebElement myselfRadio = driver.findElement(myself);
        if (!myselfRadio.isSelected()) {
            myselfRadio.click();
        }
        return this;
    }
    public I9Page clickContinueButton() {
        driver.findElement(continueBtn).click();
        return this;
    }




}
