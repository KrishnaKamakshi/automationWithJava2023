package SRP.PagesComponents;

import SRP.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponents {
    By flights = By.xpath("//div[@class='middle-block-cont']//a[@title='Flights']");
    By getAllLinks = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
    public void selectFlightsF()
    {
        //Clicks on the Header
        // Customized findElement for handling multiple elements
        findElement(flights).click();
    }
    public void getAllLinksFromFooter()
    {
        System.out.println(findElements(getAllLinks).size());
    }
}
