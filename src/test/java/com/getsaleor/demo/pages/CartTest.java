package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseStorePage;
import com.getsaleor.demo.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.PageGenerator;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private ApparelPage apparelPage;
    private AccessoriesPage accessoriesPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public void goToCart(){
        cartPage = PageGenerator.getInstance(CartPage.class);
        wait(2);
        cartPage.goToCart();
    }

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

//    @Test(description = "Check cart")
//    public void CheckCart(){
//        test = extentReports.createTest("Check cart");
//        goToCart();
//        softAssert.assertEquals(cartPage.iconBadge, "0");
//        softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
//        System.out.println("There are no products in your shopping cart.");
//    }

//    @Test(description = "Add Single Product Into Cart Successfully")
//    public void AddSingleProductIntoCartSuccessfully(){
//        test = extentReports.createTest("Add Single Product Into Cart Successfully");
//        homePage.clickApparelLink();
//        Common.sleep(2);
//        System.out.println("Go to Apparel Page");
//
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        Common.sleep(2);
//        apparelPage.selectARandomProduct();
//        Common.sleep(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        String productName = productPage.getProductName();
//        if(productPage.txtQuantity.isDisplayed()){
//            productPage.typeQuantity("1");
//            Common.sleep(2);
//            productPage.clickAddToCart();
//            Common.sleep(2);
//            goToCart();
//            softAssert.assertEquals(cartPage.getNumberProduct(), "1");
//            softAssert.assertEquals(cartPage.getProductName(), productName);
//            System.out.println("Add product successfully. Cart has 1 product.");
//        }
//        else{
//            softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
//            System.out.println("This product is currently unavailable.");
//        }
//    }
//
    @Test(description = "Add 2 Product")
    public void AddManyRandomProductsIntoCart(){
        test = extentReports.createTest("Add Many Random Products Into Cart");
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        wait(2);
        System.out.println("Go to Apparel Page");
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(3);
        apparelPage.selectARandomProduct();
        wait(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName1 = productPage.getProductName();
        if(productPage.txtQuantity.isDisplayed()){
            productPage.typeQuantity("1");
            productPage.clickAddToCart();
            wait(3);
        }else{
            System.out.println("This product is currently unavailable.");
        }
        //Select A Product in Groceries page
        homePage.clickApparelLink();
        wait(2);
        accessoriesPage = PageGenerator.getInstanceStorePage(AccessoriesPage.class);
        apparelPage.selectARandomProduct();
        wait(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName2 = productPage.getProductName();
        if(productPage.txtQuantity.isDisplayed()){
            productPage.typeQuantity("1");
            productPage.clickAddToCart();
            wait(3);
        }else{
            System.out.println("This product is currently unavailable.");
        }
        Common.sleep(2);
        goToCart();
        String[] productName = {productName1, productName2};
        softAssert.assertEquals(cartPage.getNumberProduct(), "2");
        softAssert.assertEquals(cartPage.getProductName(), productName);
        System.out.println("Add Many Random Products Into Cart Successfully.");
    }

//    @Test(description = "Change the number of products in cart")
//    public void ChangeTheNumberOfProductsInCart(){
//        test = extentReports.createTest("Change the number of products in cart");
//        //Select A Product in Apparel page
//        homePage.clickApparelLink();
//        System.out.println("Go to Apparel Page");
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        Common.sleep(3);
//        apparelPage.selectARandomProduct();
//        wait(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        if(productPage.txtQuantity.isDisplayed()) {
//            productPage.clickAddToCart();
//            Common.sleep(3);
//            goToCart();
//            //Change random quantity of product
//            int changedNumber = BaseStorePage.typeQuatity(5);
//            cartPage.typeQuantity(String.valueOf(changedNumber));
//            cartPage.clickToSpace();
//            Common.sleep(3);
//            softAssert.assertEquals(cartPage.getNumberProduct(), changedNumber);
//            //assertion
//            if (changedNumber == 0) {
//                goToCart();
//                softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
//            }
//            System.out.println("Change quantity of product succeed.");
//        }else{
//            softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
//            System.out.println("This product is currently unavailable.");
//        }
//        softAssert.assertAll();
//    }
//
//    @Test(description = "Remove the product from cart")
//    public void RemoveProduct(){
//        test = extentReports.createTest("Remove the product from cart");
//        //Select A Product in Apparel page
//        homePage.clickApparelLink();
//        wait(2);
//        System.out.println("Go to Apparel Page");
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        Common.sleep(5);
//        apparelPage.selectARandomProduct();
//        Common.sleep(3);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        if(productPage.txtQuantity.isDisplayed()){
//            productPage.typeQuantity("1");
//            Common.sleep(2);
//            productPage.clickAddToCart();
//            Common.sleep(2);
//            goToCart();
//            cartPage.clickBin();
//            softAssert.assertEquals(cartPage.iconBadge, "0");
//            softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
//            System.out.println("There are no products in your shopping cart.");
//        }else{
//            softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
//            System.out.println("This product is currently unavailable.");
//        }
//    }
}
