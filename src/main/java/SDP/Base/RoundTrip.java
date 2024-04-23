package SDP.Base;

import SDP.AbstractComponents.SearchFlightAvail;
import SRP.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends AbstractComponents implements SearchFlightAvail {
    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By originStation = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destinationStation  = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By searchByID =  By.id("ctl00_mainContent_btn_FindFlights");
    private By seniorCitizenCheck = By.id("ctl00_mainContent_chk_SeniorCitizenDiscount");
    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
    // Fetch all the Locators and stored in a Private variable
    @Override
    public void checkAvail(String origin, String destn) throws InterruptedException {
        findElement(rdo).click();
        selectDepartureCity(origin);
        selectArrivalCity(destn);
        findElement(seniorCitizenCheck).click();
        findElement(searchByID).click();
    }
    public void selectDepartureCity(String origin)
    {
        findElement(originStation).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectArrivalCity(String destn)
    {
        findElement(destinationStation).click();
        findElement(By.xpath("(//a[@value='"+destn+"'])[2]")).click();
    }
}
