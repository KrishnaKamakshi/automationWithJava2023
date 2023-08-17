package listeners;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


@Slf4j
public class CustomListeners implements ITestListener {
    FailedTest screen = new FailedTest();
    public void onFinish(ITestContext Result) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onStart(ITestContext Result) {
        // TODO Auto-generated method stub
        log.info("On Start Message is shown as " + Result.getName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        log.info("Failed build within success percentage is " + ITestResult.SUCCESS_PERCENTAGE_FAILURE);

    }
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        log.info(result.getMethod().getMethodName());
        screen.savescreenshotFailure();

    }@Override
    public void onTestSkipped(ITestResult Result) {
        // TODO Auto-generated method stub

        log.info(Result.getName() +" Test case got skipped ");

    }
    @Override
    public void onTestStart(ITestResult Result) {
        log.info("On Start Message is shown as " + Result.getName());

    }@Override
    public void onTestSuccess(ITestResult Result) {
        // TODO Auto-generated method stub
    }
}
