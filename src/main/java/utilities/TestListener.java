package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info("Start test case: " + iTestResult.getMethod().getDescription());
        LogUtils.info("==============================================================");

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info("TEST CASE STATUS: PASSED");
        LogUtils.info("--------------------------------------------------------------");
        LogUtils.info("");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LogUtils.info("TEST CASE STATUS: FAILED");
        LogUtils.info("--------------------------------------------------------------");
        LogUtils.info("");
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }
    @Override
    public void onStart(ITestContext iTestContext) {

    }
    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
