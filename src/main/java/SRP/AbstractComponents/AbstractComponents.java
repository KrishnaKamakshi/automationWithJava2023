package SRP.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponents {
    WebElement sectionElement;
    public AbstractComponents(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement); // this needs to be learnt
    }

    public WebElement findElement(By findElementBy)
    {
        return  sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy)
    {
        return  sectionElement.findElements(findElementBy);
    }
}
