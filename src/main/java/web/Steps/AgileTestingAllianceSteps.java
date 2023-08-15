package web.Steps;

import UtilsInformation.DriverClass;
import UtilsInformation.WebUtils;
import io.qameta.allure.Step;

import static UtilsInformation.WebUtils.*;

public class AgileTestingAllianceSteps extends DriverClass {
    @Step("Getting the URL")
    public void getURL() throws InterruptedException {
        WebUtils.getURLWebsite("https://www.google.com");
    }
}
