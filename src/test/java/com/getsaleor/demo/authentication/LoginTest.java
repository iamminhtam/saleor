package com.getsaleor.demo.authentication;

import com.getsaleor.demo.BaseTest;
import com.getsaleor.demo.pages.HomePage;
import com.getsaleor.demo.pages.authentication.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.PageGenerator;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);

    }

    @Test(description = "Login successfully with a valid email and password")
    public void loginSucceeded(){
        //Test data
        final String USERNAME = "admin@example.com ";
        final String PASSWORD = "admin";

        //Test case
        homePage.clickLogin();
//        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage = new LoginPage();
        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(USERNAME)
                 .typePassword(PASSWORD)
                 .clickLoginBtn();
        Common.sleep(2);
        System.out.println("ok roi");
        Common.sleep(2);

    }


}
