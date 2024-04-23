package AbstractComponents;

import SDP.AbstractComponents.SearchFlightAvail;
import SDP.Base.MultiTrip;
import SDP.Base.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {
    WebDriver driver;
    By selectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType)
    {
        if (strategyType.equalsIgnoreCase("multiTrip"))
        {
            return new MultiTrip(driver, selectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundTrip"))
        {
            return new RoundTrip(driver, selectionElement);
            // if we have the issue like this , in this case we can interface as the object - both class
        }
        return null;
    }
}
