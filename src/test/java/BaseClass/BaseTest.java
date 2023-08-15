package BaseClass;

import UtilsInformation.DriverClass;
import WebAutomationTestCases.demoautomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    static WebDriver driver;
    DriverClass driverClassDemo;
    protected SoftAssert softAssert;
    protected demoautomation loginPage;

    @BeforeTest
    public void setupChrome() {
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
