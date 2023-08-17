package listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class FailedTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public void getScreenshot(String result) throws IOException
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./screenshots/"+result+".png"));

    }
    @Attachment(value ="Page screenshot", type="image/png")
    public byte[] savescreenshotFailure()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
