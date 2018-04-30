package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseStorePage;
import com.getsaleor.demo.BaseTest;
import com.getsaleor.demo.pages.authentication.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Common;
import utilities.PageGenerator;

import java.util.Random;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private ApparelPage apparelPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

//    @Test(description = "Add Single Product Into Cart Successfully")
//    public void AddSingleProductIntoCartSuccessfully(){
//        homePage.clickApparelLink();
//        Common.sleep(2);
//        System.out.println("Go to Apparel Page");
//
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        apparelPage.selectARandomProduct();
//        Common.sleep(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        String productName = productPage.getProductName();
//        productPage.typeQuantity("1");
//        productPage.clickAddToCart();
//        Common.sleep(2);
//        cartPage = PageGenerator.getInstance(CartPage.class);
//        Common.sleep(2);
//        cartPage.goToCart();
//
//        softAssert.assertEquals(cartPage.getNumberProduct(), "1");
//        softAssert.assertEquals(cartPage.getProductName(), productName);
//        System.out.println("Add product successfully. Cart has 1 product.");
//    }

//    @Test(description = "Add2Product")
//    public void AddManyRandomProductsIntoCart(){
//        //Select A Product in Apparel page
//        homePage.clickApparelLink();
//        Common.sleep(2);
//        System.out.println("Go to Apparel Page");
//
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        apparelPage.selectARandomProduct();
//        Common.sleep(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        String productName1 = productPage.getProductName();
//        productPage.typeQuantity("1");
//        Common.sleep(2);
//        productPage.clickAddToCart();
//        Common.sleep(2);
//
//        //Select A Product in Groceries page
//        homePage.clickGroceriesLink();
//        Common.sleep(2);
//        System.out.println("Go to Groceries Page");
//
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        apparelPage.selectARandomProduct();
//        Common.sleep(2);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        String productName2 = productPage.getProductName();
//        productPage.typeQuantity("1");
//        Common.sleep(2);
//        productPage.clickAddToCart();
//        Common.sleep(2);
//
//        cartPage = PageGenerator.getInstance(CartPage.class);
//        Common.sleep(2);
//        cartPage.goToCart();
//        String[] productName = {productName1, productName2};
//        softAssert.assertEquals(cartPage.getNumberProduct(), "2");
//        softAssert.assertEquals(cartPage.getProductName(), productName);
//
//        System.out.println("Add Many Random Products Into Cart Successfully.");
//
//    }

//    @Test(description = "Change the number of products in cart")
//    public void ChangeTheNumberOfProductsInCart(){
//        //Select A Product in Apparel page
//        homePage.clickApparelLink();
//        Common.sleep(3);
//        System.out.println("Go to Apparel Page");
//
//        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
//        Common.sleep(3);
//        apparelPage.selectARandomProduct();
//        Common.sleep(3);
//        productPage = PageGenerator.getInstance(ProductPage.class);
//        String productName = productPage.getProductName();
//
//        productPage.typeQuantity(BaseStorePage.typeRandomNumberOfProduct(10));
//        Common.sleep(3);
//        productPage.clickAddToCart();
//        Common.sleep(3);
//        cartPage = PageGenerator.getInstance(CartPage.class);
//        cartPage.goToCart();
//        Common.sleep(3);
//        //Change random quantity of product
//        Random random = new Random();
//        int randomQuantity = random.nextInt(10);
//        cartPage.typeQuantity(randomQuantity);
//        cartPage.clickToSpace();
//        Common.sleep(3);
//        //assertion
//        softAssert.assertEquals(cartPage.getNumberProduct(), randomQuantity);
//        System.out.println("Change quantity of product succeed.");
////        if(randomQuantity != 0){
////            String[] price = cartPage.getPrice();
////            float cost = Float.parseFloat(price[0]);
////            String subtotal = String.valueOf(cost*randomQuantity);
////            softAssert.assertEquals(cartPage.cartSubTotal.getText(), subtotal);
////        }else{
////            cartPage.goToCart();
////            Common.sleep(3);
////            softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
////        }
//    }
    @Test(description = "Remove the product from cart")
    public void RemovePrduct(){
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        Common.sleep(2);
        System.out.println("Go to Apparel Page");

        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectARandomProduct();
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName1 = productPage.getProductName();
        productPage.typeQuantity("1");
        Common.sleep(2);
        productPage.clickAddToCart();
        Common.sleep(2);

        cartPage = PageGenerator.getInstance(CartPage.class);
        Common.sleep(2);
        cartPage.goToCart();
        cartPage.clickBin();

        Common.sleep(2);
        softAssert.assertEquals(cartPage.iconBadge, "0");
        softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
        System.out.println("There are no products in your shopping cart.");

    }
}
