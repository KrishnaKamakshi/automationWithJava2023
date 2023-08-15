package web.Steps;

import UtilsInformation.DriverClass;
import UtilsInformation.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static UtilsInformation.WebUtils.*;

public class AgileTestingAllianceSteps extends DriverClass {
    @Step("Getting the URL")
    public void getURL() throws InterruptedException {
        WebUtils.getURLWebsite("https://www.google.com");
    }
    @Step("Enter Flipkart in the search bar")
    public void navigateToFlipkartSite() throws InterruptedException {
        WebUtils.keyToEnterWithXpath("//*[@id=\"APjFqb\"]", "Flipkart");
        sleep();
    }
    @Step("Clicking on Search icon after searching for a website")
    public void clickOnSearchIcon() throws InterruptedException {
        WebUtils.clickOnElementByXpath("//*[@id=\"jZ2SBf\"]");
        sleep();
    }
    @Step("Navigating to the WebSite page")
    public void clickOnWebSite() throws InterruptedException {
        WebUtils.clickOnElementByXpath("(//h3[text()='Flipkart'])[1]");
        sleep();
    }
    @Step("Waiting for the element to be visible")
    public void waitUntilElementIsVisible()
    {
        WebUtils.waitForElementVisible(By.xpath("//*[text()='Best of Electronics']"),5, 30 );
    }
}
