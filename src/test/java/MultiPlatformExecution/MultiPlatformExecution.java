package MultiPlatformExecution;

import AndroidPage.AndroidPageHome;
import HomePage.HomePage;
import WebPages.WebPageHome;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MultiPlatformExecution {
    Properties pro = new Properties();

    @Test
    public void testMultiPlatform() throws IOException {
        FileInputStream fileReader = new FileInputStream(String.join(File.separator, "src",
                "main", "resources", "application.properties"));
        pro.load(fileReader);

        String platForm = pro.getProperty("platform");

        HomePage homePages = null;

        if(platForm.equals("web")){
            homePages = new WebPageHome();
        }
        else if (platForm.equals("android")){
            homePages = new AndroidPageHome();
        }
        homePages.searchEvents("DUNE 2 ");
        homePages.selectMovies();

    }
}
