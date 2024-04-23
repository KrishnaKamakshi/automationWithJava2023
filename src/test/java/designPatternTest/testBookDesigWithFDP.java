package designPatternTest;

import SRP.BasePages.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testBookDesigWithFDP {
    By selectionElement = By.id("flightSearchContainer");
    @Test
    public void testFlightFooter() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.getFooterNavigation().getAllLinksFromFooter();
        travelHomePage.getNavigationBar().getAllLinksFromFooter();
        /**
         * Using SDP here, which will help us to call the required functions with minimal changes*/
        travelHomePage.setBookingMethodFDP("multiTrip");
        travelHomePage.checkAvailabilityOfFlight("MAA", "BLR");
    }
}
