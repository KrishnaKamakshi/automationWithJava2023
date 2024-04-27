package designPatternTest;

import SRP.BasePages.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class testBookDesigWithFDP {
    By selectionElement = By.id("flightSearchContainer");
    @Test
    public void testFlightFooter() throws InterruptedException, URISyntaxException, MalformedURLException {
        DesiredCapabilities desCaps = new DesiredCapabilities();
        desCaps.setBrowserName("chrome");
        //desCaps.setPlatform(Platform.WIN11);
        //desCaps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.0.3:4444").toURL(), desCaps);
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
