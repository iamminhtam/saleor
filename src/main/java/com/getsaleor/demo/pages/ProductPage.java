package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementAction;

public class ProductPage extends BasePage {
    /*
    ELEMENTS
     */
    @FindBy(css = "h1.product__info__name")
    WebElement txtProductName;
    @FindBy(id = "id_quantity")
    WebElement txtQuantity;
    @FindBy(css = "button.btn.primary")
    WebElement btnAddToCart;

    /*
    PUBLIC ACTION
     */
    public void typeQuantity(String i){
        if(txtQuantity != null){
            ElementAction.type(txtQuantity, "Quantity", i);
        }
    }
    public void clickAddToCart(){
        if(btnAddToCart != null){
            ElementAction.click(btnAddToCart, " ADD TO CART");
        }
    }
    public String getProductName(){
        return txtProductName.getText();
    }
    public String getQuantity(){
        return txtQuantity.getText();
    }
}
