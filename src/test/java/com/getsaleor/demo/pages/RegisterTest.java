package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.PageGenerator;

public class RegisterTest extends BaseTest{
    private HomePage homePage;
    private RegisterPage registerPage;

    public String[] getTestData(String testCase){
        testData = dataReader.get(testCase);
        testData = dataReader.get("tc101");
        final String EMAIL = (String) testData.get("email");
        final String PASSWORD = (String) testData.get("password");
        final String MESSAGE = (String) testData.get("message");
        String[] testData = {EMAIL, PASSWORD, MESSAGE};
        return testData;
    }
    public void register(String email, String password){
        homePage.clickRegister();
        registerPage = PageGenerator.getInstance(RegisterPage.class);
        registerPage.typeEmail(email)
                    .typePassword(password)
                    .clickCreateBtn();
        wait(1);
    }

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

    @Test(description = "Register successfully with a valid email and password", priority = 1)
    public void RegisterSuccessfullyWithAValidEmailAndPassword(){
        test = extentReports.createTest("Register successfully with a valid email and password");
        //Test data
        String[] testData = getTestData("tc101");
        //Test steps
        register(testData[0], testData[1]);
        System.out.println("Registered successfully");
        //Assertion
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        String[] rightNavItemsLoggedIn = {"YOUR ACCOUNT", "LOG OUT"};
        softAssert.assertEquals(homePage.getGoToRightNav(), rightNavItemsLoggedIn);
        softAssert.assertEquals(homePage.getMessageWhenRegister(), testData[2]);
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        String[] rightNavItemsLogout = {"REGISTER", "LOG IN"};
        softAssert.assertEquals(homePage.getGoToRightNav(),rightNavItemsLogout);
        softAssert.assertEquals(homePage.getMessageWhenLogout(), "You have been successfully logged out.");
        softAssert.assertAll();
        System.out.println("Logged out");
    }

    @Test(description = "Register unsuccessfully as existing email address", priority = 2)
    public void RegisterUnsuccessfullyAsExistingEmailAddress(){
        test = extentReports.createTest("Register unsuccessfully as existing email address");
        //Test data
        String[] testData = getTestData("tc102");
        //Test steps
        register(testData[0], testData[1]);
        softAssert.assertEquals(registerPage.getErrorMessage(),testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Register unsuccessfully as invalid email address", priority = 3)
    public void RegisterUnsuccessfullyAsInvalidEmailAddress(){
        test = extentReports.createTest("Register unsuccessfully as invalid email address");
        //Test data
        String[] testData = getTestData("tc103");
        //Test steps
        register(testData[0], testData[1]);
        softAssert.assertEquals(registerPage.getErrorMessage(),testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Register unsuccessfully as missing email address", priority = 4)
    public void RegisterUnsuccessfullyAsMissingEmailAddress(){
        test = extentReports.createTest("Register unsuccessfully as missing email address");
        //Test data
        String[] testData = getTestData("tc104");
        //Test steps
        register(testData[0], testData[1]);
        System.out.println("Register unsuccessfully as missing email");
        softAssert.assertEquals(getTitlePage(), "Sign Up — Saleor demo");
        softAssert.assertAll();
    }

    @Test(description = "Register unsuccessfully as missing password", priority = 5)
    public void RegisterUnsuccessfullyAsMissingPassword(){
        test = extentReports.createTest("Register unsuccessfully as missing password");
        //Test data
        String[] testData = getTestData("tc105");
        //Test steps
        register(testData[0], testData[1]);
        System.out.println("Register unsuccessfully as missing password");
        softAssert.assertEquals(getTitlePage(),"Sign Up — Saleor demo");
        softAssert.assertAll();
    }

    @Test(description = "Register unsuccessfully as invalid password", priority = 6)
    public void RegisterUnsuccessfullyAsInvalidPassword(){
        test = extentReports.createTest("Register unsuccessfully as invalid password");
        //Test data
        String[] testData = getTestData("tc106");
        //Test steps
        register(testData[0], testData[1]);
        System.out.println("Register unsuccessfully as invalid password");
        softAssert.assertEquals(getTitlePage(),"Sign Up — Saleor demo");
        softAssert.assertAll();
    }
}
