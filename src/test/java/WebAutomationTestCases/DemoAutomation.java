package WebAutomationTestCases;

import BaseClass.BaseClass1;
import UtilsInformation.WebUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import web.Steps.AgileTestingAllianceSteps;

import static driverClass.DriverFinal.driver;


public class DemoAutomation extends BaseClass1 {
    @Description("Navigation to Flipkart Page")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void testUrlNavigation() throws InterruptedException {
        driver.get("https://www.google.com");
    }
}
