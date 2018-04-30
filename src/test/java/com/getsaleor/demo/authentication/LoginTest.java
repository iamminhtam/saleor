package com.getsaleor.demo.authentication;

import com.getsaleor.demo.BaseTest;
import com.getsaleor.demo.pages.HomePage;
import com.getsaleor.demo.pages.authentication.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.DataReader;
import utilities.PageGenerator;

import javax.annotation.processing.SupportedSourceVersion;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

    @Test(description = "Login successfully with a valid email and password")
    public void loginSucceededWithAValidEmailAndPassword(){
        //Test data
        testData = dataReader.get("tc01");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");

        //Test steps
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(2);
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

        //Test data
        testData = dataReader.get("tc02");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final  String ERROR_MESSAGE = (String) testData.get("errorMessage");

        //Test steps
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(2);
        System.out.println("loginUnsuccessfullyWithInvalidUsernameOrPassword");

        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
        softAssert.assertAll();
        Common.sleep(1);
    }
    @Test(description = "Log in unsuccessfully as missing username or password")
    public void loginUnsuccessfullyWhenMissingUsernameOrPassword(){
        //Test data
        testData = dataReader.get("tc03");
//        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final  String ERROR_MESSAGE = (String) testData.get("errorMessage");
        System.out.println(ERROR_MESSAGE);
        //Step test
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.clearUsername()
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(2);
        System.out.println("LoginUnsuccessfullyAsMissingUsernameOrPassword");
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
        softAssert.assertAll();
        Common.sleep(1);
    }
    @Test(description = "Log in unsuccessfully as username is not case sensitive")
    public void logInUnsuccessfullyAsUsernameIsNotCaseSensitive(){
        //Test data
        testData = dataReader.get("tc04");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String ERROR_MESSAGE = (String) testData.get("errorMessage");

        //Test steps
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(1);
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
        softAssert.assertAll();
        Common.sleep(1);
    }

    @Test(description = "Log in successfully as username is trimmed before validation")
    public void logInSuccessfullyAsUsernameIsTrimmedBeforeValidation(){
        //Test data
        testData = dataReader.get("tc05");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");

        //Test steps
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(2);
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

    @Test(description = "Log in unsuccessfully as username is an invalid email address")
    public void logInUnsuccessfullyAsUsernameIsAnInvalidEmailAddress(){
        //Test data
        testData = dataReader.get("tc06");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String ERROR_MESSAGE = (String) testData.get("errorMessage");

        //Test steps
        homePage.clickLogin();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(1);
        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
        softAssert.assertAll();
        Common.sleep(1);
    }


}
