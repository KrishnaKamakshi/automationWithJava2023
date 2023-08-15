package UtilsInformation;

import Config.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebUtils extends DriverConfig {
    public static void getURLWebsite(String url)
    {
        driver.get(url);
    }
    public static WebElement getElementByID(String value)
    {
        return driver.findElement(By.id(value));
    }

    public static WebElement getElementByXpath(String valueOf)
    {
        return driver.findElement(By.xpath(valueOf));
    }

    public static String getTextFromAttributeValue(String valueText)
    {
        return driver.findElement(By.id(valueText)).getText();
    }
    public static String getTextFromAttributeValueXpath(String valueText)
    {
        return driver.findElement(By.xpath(valueText)).getText();
    }

    public static String getTextFromAttributeValueText(String valueText)
    {
        return driver.findElement(By.xpath(valueText)).getText();
    }
    public static int gettingTheSize(String valueOfSize)
    {
        return driver.findElements(By.xpath(valueOfSize)).size();
    }

    public static String getTheTitle()
    {
        return driver.getTitle();
    }
    public static List<WebElement> getElementsByXpathWood(String valueOf)
    {
        return driver.findElements(By.xpath(valueOf));
    }
    public static List<WebElement> getElementsByXpathElements(String valueOf)
    {
        return driver.findElements(By.xpath(valueOf));
    }
    public static void getElemenetByIDSendValues(String valueOfLocator)
    {
        driver.findElement(By.id(valueOfLocator));
    }
    public static void clickOnElementByXpath(String xpath)
    {
        driver.findElement(By.xpath(xpath)).click();
    }
    public static String getByElements(String xpath, int index, String href)
    {
        return driver.findElements(By.xpath(xpath)).get(index).getAttribute(href);
    }
    public static WebElement getByElementsIndex(String xpath, int index)
    {
        return driver.findElements(By.xpath(xpath)).get(index);
    }

    public static String getByElementsText(String xpath, int index)
    {
        return driver.findElements(By.xpath(xpath)).get(index).getText();
    }
    public static void sendTheValueByID(String ID, String enterTheValue)
    {
        driver.findElement(By.id(ID)).sendKeys(enterTheValue);
    }
    public static void keyToEnter(String ID)
    {
        driver.findElement(By.id(ID)).sendKeys(Keys.ENTER);
    }
    public static String getTheValueByXpath(String xpath, int index)
    {
        return driver.findElements(By.xpath(xpath)).get(index).getText();
    }

    public static void sleep() throws InterruptedException
    {
        Thread.sleep(3000);
    }

}
