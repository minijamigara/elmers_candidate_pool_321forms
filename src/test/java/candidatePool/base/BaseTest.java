package candidatePool.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        if (driver == null) {  // Ensure that the driver is initialized only once
            System.setProperty("webdriver.chrome.driver", "/home/administrator/Selenium Projects/Elmers/Elmer-s_candidate_pool/resources/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            // Initialize the LoginPage object
            loginPage = new LoginPage(driver);https://elmmbl-lts-atom.orangehrm.com/
            // Now you can call goHome() safely
            goHome();
        }
    }

    public void goHome() {
        driver.get("https://elmmbl-lts-atom.orangehrm.com/");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset driver to null after closing the browser
        }
    }
}
