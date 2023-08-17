package listeners;

import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Slf4j
public class ExtentReportListener implements ITestListener {
    private static final String OUTPUT_FOLDER = "./test/resources/";
    private static final String FILE_NAME = "TestExecutionReport.html";
    private static ExtentReports extent = init();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();    private static ExtentReports extentReports;


    private static ExtentReports init() {

        Path path = Paths.get(OUTPUT_FOLDER);
        // if directory exists?
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                // fail to create directory
                e.printStackTrace();
            }
        }
        extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("Krishna QA Automation Test Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "Windows 11");
        extentReports.setSystemInfo("Author", "Krishna Kamakshi Brahma");
        extentReports.setSystemInfo("Build#", "0.1");
        extentReports.setSystemInfo("Team", "Krishna QA Team");
        extentReports.setSystemInfo("Customer Name", "NAL");
        extentReports.setSystemInfo("ENV NAME", System.getProperty("env"));
        reporter.config().setTheme(Theme.DARK);
        return extentReports;
    }
    @Override
    public synchronized void onStart(ITestContext context) {
        log.info("On Start Message is shown as ");

    }
    @Override
    public synchronized void onFinish(ITestContext context) {
        log.info("Test Suite Execution is completed");
        extent.flush();
        test.remove();
    }
    @Override
    public synchronized void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String qualifiedName = result.getMethod().getQualifiedName();
        int last = qualifiedName.lastIndexOf(".");
        int mid = qualifiedName.substring(0, last).lastIndexOf(".");
        String className = qualifiedName.substring(mid + 1, last);

        System.out.println(methodName + " started!");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());

        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        extentTest.assignCategory(className);
        test.set(extentTest);
        test.get().getModel().setStartTime(getTime(result.getStartMillis()));
    }
    public synchronized void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        log.info(methodName + " method execution is completed for the given suite");
        test.get().pass("Test passed");
        //test.get().pass(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot(methodName), methodName).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }
    public synchronized void onTestFailure(ITestResult result) {
        log.error(result.getMethod().getMethodName() + " method execution is failed for the given suite");
        //test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot(methodName), methodName).build());
        //test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }
    public synchronized void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        log.debug(methodName + " method execution is skipped for the given suite");
        //test.get().skip(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(DriverFactory.getScreenshot(methodName), methodName).build());
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
