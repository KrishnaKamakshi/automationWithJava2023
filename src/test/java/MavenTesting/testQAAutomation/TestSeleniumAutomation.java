package MavenTesting.testQAAutomation;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSeleniumAutomation {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://google.com");
        Thread.sleep(10);


    }

}
