package MultiPlatformExecution;

import AndroidPage.AndroidPageHome;
import Factory.PageFactory;
import HomePage.HomePage;
import WebPages.WebPageHome;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MultiPlatformExecutionTests {
    PageFactory pageFactory = PageFactory.getPageFactory();


    @Test
    public void testMultiPlat() throws IOException {

        HomePage homePage = pageFactory.getHomePage();
        homePage.searchEvents("search for movie");
        homePage.selectMovies();

    }

    @Test
    public void testMultiPlat2() throws IOException {

        HomePage homePage = pageFactory.getHomePage();
        homePage.searchEvents("search for movie");
        homePage.selectMovies();

    }
}
