package designPatternTest;

import SDP.Base.RoundTrip;
import SRP.BasePages.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testBookDesignationAndArivalFlights {
    By selectionElement = By.id("flightSearchContainer");
    @Test
    public void testFlightFooter() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.getFooterNavigation().getAllLinksFromFooter();
        travelHomePage.getNavigationBar().getAllLinksFromFooter();
        travelHomePage.setBookingMethod(new RoundTrip(driver,selectionElement));
        travelHomePage.checkAvailabilityOfFlight("MAA", "BLR");
    }
}
