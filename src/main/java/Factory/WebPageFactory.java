package Factory;

import HomePage.HomePage;
import WebPages.WebPageHome;

public class WebPageFactory extends PageFactory{
    @Override
    public HomePage getHomePage() {
        return new WebPageHome();
    }
}
