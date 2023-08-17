package UtilsInformation;

import Config.DriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class DriverClass extends DriverConfig {
    @BeforeSuite
    public void setupChrome() {
        WebDriverManager.chromedriver().create();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}
