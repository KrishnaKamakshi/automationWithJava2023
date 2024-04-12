package WebAutomationTestCases;

import BaseClass.BaseClass1;
import UtilsInformation.WebUtils;
import driverClass.DriverFinal;
import org.testng.annotations.Test;

import static driverClass.DriverFinal.driver;

public class testDemoFinal extends BaseClass1 {
    private testDemoFinal()
    {}

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebUtils.keyToEnterWithXpath("//*[@id=\"APjFqb\"]", "Flipkart");
        Thread.sleep(5000);

    }
}
