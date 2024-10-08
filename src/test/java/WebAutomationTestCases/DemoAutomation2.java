package WebAutomationTestCases;

import BaseClass.BaseClass1;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import web.Locators.LoginPageFactory;
import web.Steps.AgileTestingAllianceSteps;

import java.util.concurrent.TimeUnit;

import static driverClass.DriverFinal.driver;


public class DemoAutomation2 extends BaseClass1 {
    LoginPageFactory loginFactory = new LoginPageFactory();
    @Description("Navigation to Flipkart Page")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void testUrlNavigationRahulShetty() throws InterruptedException {
        driver.get("https://courses.rahulshettyacademy.com/");
        loginFactory.clickOnLandingPage();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginFactory.clickOnSignWithUpEmail();
        Thread.sleep(30);
        loginFactory.waitElementIsVisible();
        loginFactory.sendDetailsString("user_name","Krishna Kamakshi Brahma");
        loginFactory.sendDetailsString("user_email","ckrishnagitam@outlook.com");
        loginFactory.sendDetailsString("password","^K*TestQA");
    }
}
