package Factory;

import AndroidPage.AndroidPageHome;
import HomePage.HomePage;
import WebPages.WebPageHome;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public abstract class PageFactory {
    static Properties properties = new Properties();
    static String platform;

    public static PageFactory getPageFactory()  {
        try {
            String filePath = String.join(File.separator,
                    "src", "main",
                    "resources",
                    "application.properties");
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);

            platform = properties.getProperty("platform");
            return switch (platform){
                case "web" -> new WebPageFactory();
                case "android" -> new AndroidPageFactory();
                default -> throw  new IllegalAccessException(" Not a valid Platform");
            };
        } catch ( Exception e){
            System.out.println("page factory not initialized");
        }
        return null;
    }
    public abstract HomePage getHomePage();
}
