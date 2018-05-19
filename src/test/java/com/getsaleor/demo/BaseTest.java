package com.getsaleor.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.DataReader;
import utilities.DriverFactory;
import utilities.LogUtils;
import utilities.PageGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest extends ExtentReports {

    private WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected DataReader dataReader = new DataReader(Const.DATA_FILE);
    protected JSONObject testData;
    public static ExtentReports extentReports;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    public String getTitlePage(){
        return driver.getTitle();
    }

    @BeforeSuite
    public void startReport(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/TestReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Host Name", "AutomationReport");
        extentReports.setSystemInfo("Environment", "Automation Testing");
        extentReports.setSystemInfo("User Name", "Tam Nguyen");

        htmlReporter.config().setDocumentTitle("Automation Regression Test");
        htmlReporter.config().setReportName("Test report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    @Parameters("browser")
    @BeforeTest
    public void initializeTest(String browserName){
        driver = DriverFactory.getDriverInstance(browserName);
        driver.get(Const.SITE_URL); //go to page - refresh the page and change url
        PageGenerator.initializeDriver(driver);
        LogUtils.info("Go to Saleor");
    }


    @AfterTest
    public void cleanUpTest(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeEachMethod(){
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            test.fail(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable());
        }else if( result.getStatus() == ITestResult.SUCCESS){
            test.pass(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
        }else{
            test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
            test.skip(result.getThrowable());
        }
    }
    @AfterSuite
    public void endReport(){
        extentReports.flush();
    }

}
