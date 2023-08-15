package WebAutomationTestCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import web.Steps.AgileTestingAllianceSteps;



public class demoautomation extends AgileTestingAllianceSteps {
    @Test
    public void testUrlNavigation() throws InterruptedException {
        getURL();
    }

}
