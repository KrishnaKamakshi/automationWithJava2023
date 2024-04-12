package driverClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFinal {
    public static WebDriver driver;
    public static void initDriver()
    {
        if(driver==null) {
            //WebDriverManager.chromedriver().create();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }
    public static  void quitDriver()
    {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}
