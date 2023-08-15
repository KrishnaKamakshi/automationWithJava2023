package WebAutomationTestCases;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import web.Steps.AgileTestingAllianceSteps;


public class DemoAutomation extends AgileTestingAllianceSteps {
    @Description("Navigation to Flipkart Page")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void testUrlNavigation() throws InterruptedException {
        getURL();
        navigateToFlipkartSite();
        clickOnSearchIcon();
        clickOnWebSite();
        waitUntilElementIsVisible();
    }
}
