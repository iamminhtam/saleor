package com.getsaleor.demo;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.DataReader;
import utilities.DriverFactory;
import utilities.PageGenerator;

public class BaseTest {

    private WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected DataReader dataReader = new DataReader(Const.DATA_FILE);
    protected JSONObject testData;

    @Parameters("browser")
    @BeforeTest
    public void initializeTest(String browserName){
        driver = DriverFactory.getDriverInstance(browserName);
        driver.get(Const.SITE_URL); //go to page - refresh the page and change url
        PageGenerator.initializeDriver(driver);
        System.out.println("Go to Saleor");
    }
    @AfterTest
    public void cleanUpTest(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeEachMethod(){
        softAssert = new SoftAssert();
    }

}
