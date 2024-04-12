package UtilsInformation;

import Config.DriverConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class DriverClass extends DriverConfig {
    @BeforeSuite
    public void setupChrome() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }
}