package SRP.PagesComponents;

import SRP.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbstractComponents {
    /**
     * Methods to handle the Flights Information
     * ***/
    WebDriver driver;
    By flights = By.xpath("//div[@class='middle-block-cont']//a[@title='Flights']");
    By getAllLinks = By.cssSelector("a");
    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver,sectionElement); // When we inherit parent class- you should invoke parent class constructor in your own constructor
    }
    public void selectFlights()
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
