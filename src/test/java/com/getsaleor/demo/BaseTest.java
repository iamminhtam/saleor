package com.getsaleor.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilities.DriverFactory;
import utilities.ElementFinder;
import utilities.PageGenerator;

public class BaseTest {

    private WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @Parameters("browser")
    @BeforeTest
    public void initializeTest(){
        String browserName = "chrome";
        driver = DriverFactory.getDriverInstance(browserName);
        driver.get(Const.SITE_URL);
        PageGenerator.initializeDriver(driver);
        ElementFinder.initializeDriver(driver);
        System.out.println("Go to Saleor site home page");
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
