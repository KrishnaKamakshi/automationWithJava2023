package SRP.BasePages;

import AbstractComponents.StrategyFactor;
import SDP.AbstractComponents.SearchFlightAvail;
import SRP.PagesComponents.FooterNavigation;
import SRP.PagesComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    // This is a Base Page
    // From this Base Page, we will dedicate to the functionality to multiple classes
    // Objects / locators should be stored here
    WebDriver driver;
    By sectionElement = By.id("traveller-home");
    By footerNaveSection = By.id("buttons");
    SearchFlightAvail searchFlightAvail;
    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public NavigationBar getNavigationBar()
    {
        // this should give the instance of other class
        return new NavigationBar(driver, footerNaveSection);
    }
    public FooterNavigation getFooterNavigation()
    {
        return new FooterNavigation(driver, sectionElement);
    }

    public void setBookingMethod(SearchFlightAvail searchFlightAvail)
    {
        this.searchFlightAvail = searchFlightAvail;
    }

    public void setBookingMethodFDP(String strategyType)
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvailabilityOfFlight(String origin, String desn) throws InterruptedException {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail.checkAvail(origin, desn);
    }
}
