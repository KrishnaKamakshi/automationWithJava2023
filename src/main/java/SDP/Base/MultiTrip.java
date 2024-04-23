package SDP.Base;

import SDP.AbstractComponents.SearchFlightAvail;
import SRP.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiTrip extends AbstractComponents implements SearchFlightAvail {
    private By multido = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By popUpModal = By.id("MultiCityModelAlert");
    private By originStation = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destinationStation  = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By originStation2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By destinationStation2  = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By originStation3 = By.id("ctl00_mainContent_ddl_originStation3_CTXT");
    private By destinationStation3  = By.id("ctl00_mainContent_ddl_destinationStation3_CTXT");
    private By searchByID =  By.id("ctl00_mainContent_btn_FindFlights");
    private By seniorCitizenCheck = By.id("ctl00_mainContent_chk_StudentDiscount");
    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }
    @Override
    public void checkAvail(String origin, String destn) throws InterruptedException {
        findElement(multido).click();
        findElement(popUpModal).click();
        selectDepartureCity(origin);
        selectArrivalCity(destn);
        selectDepartureCity2("AIP");
        selectArrivalCity2("GOI");
        selectDepartureCity3("BHO");
        selectArrivalCity3("BOM");
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
    public void selectDepartureCity2(String origin)
    {
        findElement(originStation2).click();
        findElement(By.xpath("(//a[@value='"+origin+"'])[3]")).click();
    }
    public void selectArrivalCity2(String destn)
    {
        findElement(destinationStation2).click();
        findElement(By.xpath("(//a[@value='"+destn+"'])[4]")).click();
    }
    public void selectDepartureCity3(String origin)
    {
        findElement(originStation3).click();
        findElement(By.xpath("(//a[@value='"+origin+"'])[5]")).click();
    }
    public void selectArrivalCity3(String destn)
    {
        findElement(destinationStation3).click();
        findElement(By.xpath("(//a[@value='"+destn+"'])[6]")).click();
    }
}
