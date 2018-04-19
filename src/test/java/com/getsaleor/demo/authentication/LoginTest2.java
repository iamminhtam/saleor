package com.getsaleor.demo.authentication;

import com.getsaleor.demo.BaseTest;
import com.getsaleor.demo.pages.HomePage;
import com.getsaleor.demo.pages.authentication.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.PageGenerator;

public class LoginTest2 extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

//    @Test(description = "Login successfully with a valid email and password")
//    public void loginSucceeded(){
//        //Test data
//        testData = dataReader.get("tc01");
//        final String USERNAME = (String) testData.get("username");
//        final String PASSWORD = (String) testData.get("password");
//        final  String MESSAGE = (String) testData.get("message");
//
//        //Test case
//        homePage.clickLogin();
//        loginPage = PageGenerator.getInstance(LoginPage.class);
//        loginPage.typeUsername(USERNAME)
//                .typePassword(PASSWORD)
//                .clickLoginBtn();
//        Common.sleep(2);
//        System.out.println("Logged in to successfully");
//        //Assertion
//        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
//        String[] rightNavItemsLoggedIn = {"DASHBOARD", "YOUR ACCOUNT", "LOG OUT"};
//        softAssert.assertEquals(homePage.getGoToRightNav(), rightNavItemsLoggedIn);
//
//        //logout
//        homePage.clickLogout();
//        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
//        String[] rightNavItemsLogout = {"REGISTER", "LOG IN"};
//        softAssert.assertEquals(homePage.getGoToRightNav(),rightNavItemsLogout);
//        softAssert.assertEquals(homePage.getMessageWhenLogout(), "You have been successfully logged out.");
//        softAssert.assertAll();
//        System.out.println("Logged out");
//    }

    @Test(description = "Log in unseccessfully with invalid username or passsword")
    public void loginUnsucceeded(){
        homePage = PageGenerator.getInstance(HomePage.class);
        //Test data
        testData = dataReader.get("tc02");
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final  String ERROR_MESSAGE = (String) testData.get("errorMessage");

        //Test steps
        homePage.clickLogin();
        loginPage.typeUsername(USERNAME)
                .typePassword(PASSWORD)
                .clickLoginBtn();
        Common.sleep(2);

        //Assertion
        softAssert.assertEquals(loginPage.getErrorMessage(), ERROR_MESSAGE);
        softAssert.assertAll();
        Common.sleep(1);

    }


}
