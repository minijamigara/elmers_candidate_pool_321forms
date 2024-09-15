package forms321.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.Login321Page;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static Login321Page login321Page;

    @BeforeClass
    public void setUp() {
        ConfigLoader config = new ConfigLoader();
        if (driver == null) {  // Ensure that the driver is initialized only once
            System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            // Initialize the LoginPage object
            login321Page = new Login321Page(driver);

            // Now you can call goHome() safely
            goHome();
        }
    }

    public void goHome() {
        ConfigLoader config = new ConfigLoader();
        driver.get(config.getBaseUrl());
    }


/*    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset driver to null after closing the browser
        }
    }*/
}
