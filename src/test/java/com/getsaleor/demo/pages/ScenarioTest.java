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

    public String[] getTestData(String testCase){
        testData = dataReader.get(testCase);
        final String USERNAME = (String) testData.get("username");
        final String PASSWORD = (String) testData.get("password");
        final String MESSAGE = (String) testData.get("message");
        String[] testData = {USERNAME, PASSWORD, MESSAGE};
        return testData;
    }
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

    @Test(description = "Login > Add product to cart > Logout", priority = 2)
    public void LoginAddProductToCartLogout(){
        test = extentReports.createTest("Login > Add product to cart > Logout");
        //Test data
        String[] testData = getTestData("sce02");
        //Login
        homePage.clickLogin();
        login(testData[0], testData[1]);
        LogUtils.info("Logged in to successfully");
        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
        //add product
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(2);
        apparelPage.selectAProduct(5);
        productPage = PageGenerator.getInstance(ProductPage.class);
        productPage.selectSize("m");
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
            LogUtils.warn("This product is out of stock.");
        }
        //Logout
        homePage.clickLogout();
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        LogUtils.info("Logged out");
        softAssert.assertAll();
        homePage.clickLogin();
        login("admin@example.com","admin");
        LogUtils.info("Logged in to successfully");
        goToCart();
        softAssert.assertEquals(cartPage.getNumberProduct(), 1);
        cartPage.clickBin();
        homePage.clickLogout();
        softAssert.assertAll();
    }

    @Test(description = "Register > Select 1 Product > Add to cart > Checkout", priority = 1)
    public void RegisterSelect1ProductAddToCartCheckout(){
        test = extentReports.createTest("Register > Select 1 Product > Add to cart > Checkout ");
        //Test data
        String[] testData = getTestData("sce01");
        register(testData[0], testData[1]);
        softAssert.assertEquals(homePage.getMessageWhenRegister(), testData[2]);
        //Assertion
        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
        //add product
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectAProduct(5);
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        productPage.selectSize("l");
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
                Common.sleep(2);
            }
            else{
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.warn("This product is out of stock.");
        }
    }

//    @Test(description = "Select Product > Add to cart > Checkout", priority = 3)
//    public void SelectProductAddToCartCheckout(){
//        test = extentReports.createTest("Select Product > Add to cart > Checkout");
//        homePage.clickApparelLink();
//        Common.sleep(2);
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        apparelPage.selectAProduct(7);
//        Common.sleep(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        productPage.selectSize("xl");
//        if(productPage.btnAddToCart.isEnabled()){
//            if(productPage.txtQuantity.isDisplayed()){
//                productPage.typeQuantity("1");
//                productPage.clickAddToCart();
//                Common.sleep(3);
//                goToCart();
//                softAssert.assertEquals(cartPage.getNumberProduct(), 1);
//                LogUtils.info("Add product to cart successfully.");
//                //Check out
//                if(cartPage.btnCheckOut.isEnabled()){
//                    LogUtils.info("Check out now");
//                }
//                cartPage.clickBin();
//            }
//            else{
//                LogUtils.info("This product is currently unavailable.");
//            }
//        }else{
//            LogUtils.warn("This product is out of stock.");
//        }
//        //Logout
//        homePage.clickLogout();
//        softAssert.assertEquals(2, homePage.getGoToRightNav().length);
//        LogUtils.info("Logged out");
//        softAssert.assertAll();
//    }
//
//    @Test(description = "Login > Select Product > Add to cart > Checkout", priority = 2)
//    public void LoginSelectProductAddToCartCheckout(){
//        test = extentReports.createTest("Login > Select Product > Add to cart > Checkout");
//        //Login
//        homePage.clickLogin();
//        login("admin@example.com","admin");
//        LogUtils.info("Logged in to successfully");
//        softAssert.assertEquals(3, homePage.getGoToRightNav().length);
//        //Select A Product in Apparel page
//        homePage.clickApparelLink();
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        Common.sleep(3);
//        apparelPage.selectAProduct(1);
//        Common.sleep(3);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        productPage.selectSize("m");
//        if(productPage.btnAddToCart.isEnabled()){
//            if(productPage.txtQuantity.isDisplayed()){
//                productPage.typeQuantity("1");
//                productPage.clickAddToCart();
//                Common.sleep(3);
//                goToCart();
//                //Check out
//                if(cartPage.btnCheckOut.isEnabled()){
//                    LogUtils.info("Check out now");
//                }
//                cartPage.clickBin();
//            }else{
//                LogUtils.warn("Checkout button do not work");
//            }
//        }else{
//            LogUtils.warn("This product is out of stock.");
//        }
//    }
}
