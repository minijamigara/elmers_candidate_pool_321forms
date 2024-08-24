package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\QA Proj\\Elmers\\Elmers_candidate_pool\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Uncomment if needed
        driver.manage().window().maximize();

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Now you can call goHome() safely
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://elmb1-lts-atom.orangehrm.com/");

        // Ensure loginPage is initialized
/*        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }

        loginPage.setUsername("_ohrmSysAdmin_")
                .setPassword("admin");

        DashboardPage dashboardPage = loginPage.clickLoginButton();*/
    }

/*    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
