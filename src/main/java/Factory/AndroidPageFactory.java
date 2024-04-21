package Factory;

import AndroidPage.AndroidPageHome;
import HomePage.HomePage;

public class AndroidPageFactory extends PageFactory{
    @Override
    public HomePage getHomePage() {
        return new AndroidPageHome();
    }
}
