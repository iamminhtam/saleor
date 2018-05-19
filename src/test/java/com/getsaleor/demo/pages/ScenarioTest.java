package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.LogUtils;
import utilities.PageGenerator;

public class ScenarioTest extends BaseTest {
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ApparelPage apparelPage;
    public void login(String username, String password){

        loginPage = PageGenerator.getInstance(LoginPage.class);
        loginPage.typeUsername(username)
                .typePassword(password)
                .clickLoginBtn();
        Common.sleep(1);
    }
    public void register(String email, String password){
        homePage.clickRegister();
        registerPage = PageGenerator.getInstance(RegisterPage.class);
        registerPage.typeEmail(email)
                .typePassword(password)
                .clickCreateBtn();
        Common.sleep(1);
    }
    public void goToCart(){
        cartPage = PageGenerator.getInstance(CartPage.class);
        cartPage.goToCart();
    }

    @BeforeClass()
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

    @Test(description = "Login > Add product to cart > Logout")
    public void LoginAddProductToCartLogout(){
        test = extentReports.createTest("Login > Add product to cart > Logout");
        //Login
          homePage.clickLogin();
        login("admin@example.com","admin");
        LogUtils.info("Logged in to successfully");
        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
        //add product
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectAProduct(2);
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                Common.sleep(3);
                goToCart();
                softAssert.assertEquals(cartPage.getNumberProduct(), 1);
                LogUtils.info("Add product to cart successfully.");
                cartPage.clickBin();
                Common.sleep(2);
            }
            else{
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.info("This product is out of stock.");
        }
        //Logout
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        LogUtils.info("Logged out");
        softAssert.assertAll();
    }
    @Test(description = "Register > Select 1 Product > Add to cart > Checkout", priority = 1)
    public void RegisterSelect1ProductAddToCartCheckout(){
        test = extentReports.createTest("Register > Select 1 Product > Add to cart > Checkout ");
        //Test data
        register("tester9879870001236541111@gmail.com", "adminnnnnnn");
        LogUtils.info("Registered successfully");
        //Assertion
        softAssert.assertEquals(2, homePage. getGoToRightNav().length);
        //add product
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectAProduct(2);
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                Common.sleep(3);
                goToCart();
                softAssert.assertEquals(cartPage.getNumberProduct(), 1);
                LogUtils.info("Add product to cart successfully.");
                if(cartPage.btnCheckOut.isEnabled()){
                    LogUtils.info("Check out now");
                }
                cartPage.clickBin();
                homePage.clickLogout();
            }
            else{
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.info("This product is out of stock.");
        }
    }
    @Test(description = "Select Product > Add to cart > Checkout", priority = 3)
    public void SelectProductAddToCartCheckout(){
        test = extentReports.createTest("Select Product > Add to cart > Checkout");
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectAProduct(2);
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                Common.sleep(3);
                goToCart();
                softAssert.assertEquals(cartPage.getNumberProduct(), 1);
                LogUtils.info("Add product to cart successfully.");
                //Check out
                if(cartPage.btnCheckOut.isEnabled()){
                    LogUtils.info("Check out now");
                }
            }
            else{
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.info("This product is out of stock.");
        }
        cartPage.clickBin();
        //Logout
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        LogUtils.info("Logged out");
        softAssert.assertAll();
    }
    @Test(description = "Login > Select Product > Add to cart > Checkout", priority = 2)
    public void LoginSelectProductAddToCartCheckout(){
        test = extentReports.createTest("Login > Select Product > Add to cart > Checkout");
        //Login
        homePage.clickLogin();
        login("admin@example.com","admin");
        LogUtils.info("Logged in to successfully");
        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(3);
        apparelPage.selectAProduct(2);
        Common.sleep(3);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                Common.sleep(3);
                goToCart();
                //Check out
                if(cartPage.btnCheckOut.isEnabled()){
                    LogUtils.info("Check out now");
                }
                cartPage.clickBin();
            }else{
                LogUtils.info("Checkout button do not work");
            }
        }else{
            LogUtils.info("This product is out of stock.");
        }
    }
}
