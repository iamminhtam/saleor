package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.PageGenerator;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    public void login(String username, String password){
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(username)
                 .typePassword(password)
                 .clickLoginBtn();
        wait(2);
    }

    public String[] getTestData(String testCase){
        testData = dataReader.get(testCase);
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String MESSAGE = (String) testData.get("message");
        String[] testData = {USERNAME, PASSWORD, MESSAGE};
        return testData;
    }

    @BeforeClass
    public void beforeClass() {
        homePage = PageGenerator.getInstance(HomePage.class);
    }

    @Test(description = "Login successfully with a valid email and password")
    public void loginSucceededWithAValidEmailAndPassword(){
        test = extentReports.createTest("Login successfully with a valid email and password");
        //Test data
        String[] testData = getTestData("tc01");
        //Test steps
        login(testData[0], testData[1]);
        System.out.println("Logged in to successfully");
        //Assertion
        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
        String[] rightNavItemsLoggedIn = {"DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
        softAssert.assertEquals(homePage.getGoToRightNav(), rightNavItemsLoggedIn);
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        String[] rightNavItemsLogout = {"REGISTER", "LOG IN"};
        softAssert.assertEquals(homePage.getGoToRightNav(),rightNavItemsLogout);
        softAssert.assertEquals(homePage.getMessageWhenLogout(), "You have been successfully logged out.");
        softAssert.assertAll();
        System.out.println("Logged out");
    }

    @Test(description = "Log in unsuccessfully with invalid username or password")
    public void loginUnsuccessfullyWithInvalidUsernameOrPassword(){
        test = extentReports.createTest("Log in unsuccessfully with invalid username or password");
        //Test data
        String[] testData = getTestData("tc02");
        //Test steps
        login(testData[0],testData[1]);
        System.out.println("loginUnsuccessfullyWithInvalidUsernameOrPassword");
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Log in unsuccessfully as missing username")
    public void loginUnsuccessfullyWhenMissingUsername(){
        test = extentReports.createTest("Log in unsuccessfully as missing username or password");
        //Test data
        String[] testData = getTestData("tc03");
        System.out.println(testData[2]);
        //Step test
        login(testData[0], testData[1]);
        System.out.println("LoginUnsuccessfullyAsMissingUsername");
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Log in unsuccessfully as missing password")
    public void loginUnsuccessfullyWhenMissingPassword(){
        test = extentReports.createTest("Log in unsuccessfully as missing username or password");
        //Test data
        String[] testData = getTestData("tc04");
        //Step test
        login(testData[0], testData[1]);
        System.out.println("LoginUnsuccessfullyAsMissingPassword");
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Log in unsuccessfully as username is not case sensitive")
    public void logInUnsuccessfullyAsUsernameIsNotCaseSensitive(){
        test = extentReports.createTest("Log in unsuccessfully as username is not case sensitive");
        //Test data
        String[] testData = getTestData("tc05");
        //Test steps
        login(testData[0], testData[1]);
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Log in successfully as username is trimmed before validation")
    public void logInSuccessfullyAsUsernameIsTrimmedBeforeValidation(){
        test = extentReports.createTest("Log in successfully as username is trimmed before validation");
        //Test data
        String[] testData = getTestData("tc06");
        //Test steps
        login(testData[0], testData[1]);
        System.out.println("Logged in successfully.");
        //Assertion
        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
        String[] rightNavItemsLoggedIn = {"DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
        softAssert.assertEquals(homePage.getGoToRightNav(), rightNavItemsLoggedIn);
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        String[] rightNavItemsLogout = {"REGISTER", "LOG IN"};
        softAssert.assertEquals(homePage.getGoToRightNav(),rightNavItemsLogout);
        softAssert.assertEquals(homePage.getMessageWhenLogout(), "You have been successfully logged out.");
        softAssert.assertAll();
        System.out.println("Logged out");
    }

    @Test(description = "Log in unsuccessfully as username is an invalid email address")
    public void logInUnsuccessfullyAsUsernameIsAnInvalidEmailAddress(){
        test = extentReports.createTest("Log in unsuccessfully as username is an invalid email address");
        //Test data
        String[] testData = getTestData("tc07");
        //Test steps
        login(testData[0], testData[1]);
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }

    @Test(description = "Log in unsuccessfully as missing username and password")
    public void logInUnsuccessfullyAsMissingUsernameAndPassword(){
        test = extentReports.createTest("Log in unsuccessfully as missing username and password");
        //Test data
        String[] testData = getTestData("tc08");
        //Test steps
        login(testData[0], testData[1]);
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), testData[2]);
        softAssert.assertAll();
    }
}

