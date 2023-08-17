package web.Locators;

import UtilsInformation.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageFactory {
    @Step("Clicking on the Register Page on Landing")
    public void clickOnLandingPage() throws InterruptedException {
        WebUtils.sleep();
        WebUtils.clickOnElementByXpath("//a[normalize-space()='Register']");
    }
    @Step("Waiting for the element to be visible after clicking on Register button")
    public void waitElementIsVisible() {
        WebUtils.waitForElementVisible(By.xpath("(//h3[normalize-space()='Sign Up'])[1]"), 5, 5);
    }
    @Step("Clicking on signUpWithEmail")
    public void clickOnSignWithUpEmail()
    {
        WebUtils.clickOnElementByXpath("(//button[normalize-space()='Sign up with email'])[1]");
    }
    @Step("Entering Full name in the full name text box")
    public void sendDetailsString(String locatorName,String nameOfUser)
    {
        WebUtils.sendTheValueByID(locatorName, nameOfUser);
    }
}
