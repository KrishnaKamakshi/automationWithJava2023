package MavenTesting.testQAAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSeleniumAutomation {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(10);


    }

}
