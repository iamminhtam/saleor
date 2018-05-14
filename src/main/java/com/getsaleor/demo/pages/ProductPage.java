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
    @FindBy(xpath = "//button[contains(@class, 'primary')]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//p[contains(@class,'alert')]")
    WebElement txtAlert;
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
    public String getAlert() {
        String alert = "";
        if(txtAlert != null)    {
            alert = txtAlert.getText();
        }
        return alert;
    }
}
