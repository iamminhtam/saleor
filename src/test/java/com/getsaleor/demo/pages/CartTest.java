package com.getsaleor.demo.pages;

import com.getsaleor.demo.BaseStorePage;
import com.getsaleor.demo.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;
import utilities.Common;
import utilities.LogUtils;
import utilities.PageGenerator;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private ApparelPage apparelPage;
    private AccessoriesPage accessoriesPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;

    public void goToCart(){
        cartPage = PageGenerator.getInstance(CartPage.class);
        cartPage.goToCart();
    }

    @BeforeClass
    public void beforeClass(){
        homePage = PageGenerator.getInstance(HomePage.class);
    }

    @Test(description = "Check cart", priority = 1)
    public void CheckCart(){
        test = extentReports.createTest("Check cart");
        goToCart();
        softAssert.assertEquals(cartPage.iconBadge, "0");
        softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
        LogUtils.info("There are no products in your shopping cart.");
    }

    @Test(description = "Add Single Product Into Cart Successfully", priority = 4)
    public void AddSingleProductIntoCartSuccessfully(){
        test = extentReports.createTest("Add Single Product Into Cart Successfully");
        homePage.clickApparelLink();
        Common.sleep(2);
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        apparelPage.selectARandomProduct();
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName = productPage.getProductName();
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                goToCart();
                softAssert.assertEquals(cartPage.getNumberProduct(), "1");
                softAssert.assertEquals(cartPage.getProductName(), productName);
                LogUtils.info("Add product to cart successfully.");
            }
            else{
                softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.warn("This product is out of stock.");
        }
    }

    @Test(description = "Add 2 Product", priority = 5)
    public void AddManyRandomProductsIntoCart(){
        test = extentReports.createTest("Add Many Random Products Into Cart");
        int quantity = 0;
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(3);
        apparelPage.selectAProduct(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName1 = productPage.getProductName();
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                quantity++;
            }else{
                LogUtils.info("This product is currently unavailable.");
            }
        }
        //Select A Product in Groceries page
        homePage.clickApparelLink();
        accessoriesPage = PageGenerator.getInstanceStorePage(AccessoriesPage.class);
        apparelPage.selectAProduct(4);
        productPage = PageGenerator.getInstance(ProductPage.class);
        String productName2 = productPage.getProductName();
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                quantity++;
            }else{
                LogUtils.info("This product is currently unavailable.");
            }
        }
        Common.sleep(2);
        goToCart();
        String[] productName = {productName1, productName2};
        softAssert.assertEquals(cartPage.getNumberProduct(), quantity);
        softAssert.assertEquals(cartPage.getProductName(), productName);
        LogUtils.info("Add Many Random Products Into Cart Successfully.");
    }

    @Test(description = "Change the number of products in cart", priority = 3)
    public void ChangeTheNumberOfProductsInCart(){
        test = extentReports.createTest("Change the number of products in cart");
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(3);
        apparelPage.selectAProduct(4);
        Common.sleep(2);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.txtQuantity.isDisplayed()) {
            productPage.clickAddToCart();
            Common.sleep(3);
            goToCart();
            //Change random quantity of product
            int changedNumber = BaseStorePage.typeQuantity(5);
            cartPage.typeQuantity(String.valueOf(changedNumber));
            cartPage.clickToSpace();
            Common.sleep(3);
            softAssert.assertEquals(cartPage.getNumberProduct(), changedNumber);
            //assertion
            if (changedNumber == 0) {
                goToCart();
                softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
            }
            cartPage.clickBin();
            LogUtils.info("Change quantity of product succeed.");
        }else{
            softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
            LogUtils.info("This product is currently unavailable.");
        }
        softAssert.assertAll();
    }

    @Test(description = "Remove the product from cart", priority = 2)
    public void RemoveProduct(){
        test = extentReports.createTest("Remove the product from cart");
        //Select A Product in Apparel page
        homePage.clickApparelLink();
        apparelPage = PageGenerator.getInstanceStorePage(ApparelPage.class);
        Common.sleep(3);
        apparelPage.selectAProduct(7);
        Common.sleep(3);
        productPage = PageGenerator.getInstance(ProductPage.class);
        if(productPage.btnAddToCart.isEnabled()){
            if(productPage.txtQuantity.isDisplayed()){
                productPage.typeQuantity("1");
                productPage.clickAddToCart();
                Common.sleep(3);
                goToCart();
                cartPage.clickBin();
                softAssert.assertEquals(cartPage.iconBadge, "0");
                softAssert.assertEquals(cartPage.getInfo(), "There are no products in your shopping cart.");
                LogUtils.info("There are no products in your shopping cart.");
            }else{
                softAssert.assertEquals(productPage.getAlert(), "This product is currently unavailable.");
                LogUtils.info("This product is currently unavailable.");
            }
        }else{
            LogUtils.warn("This product is out of stock.");
        }
    }

    @Test(description = "Check out", priority = 6)
    public void Checkout(){
        test = extentReports.createTest("Checkout");
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
                cartPage.clickCheckOut();
                checkOutPage = PageGenerator.getInstance(CheckOutPage.class);
                softAssert.assertEquals(checkOutPage.getHeader(), "Checkout");
                LogUtils.info("Check out now");
            }else{
                LogUtils.warn("Checkout button do not work");
            }
        }else{
            LogUtils.warn("This product is out of stock.");
        }
    }
}
