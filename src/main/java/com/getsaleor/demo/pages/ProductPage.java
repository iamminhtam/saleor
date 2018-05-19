package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Common;
import utilities.ElementAction;

import java.util.List;

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

    @FindBy(css = "label.variant-picker__option")
    List<WebElement> sizes;
    /*
    PUBLIC ACTION
     */
    public void typeQuantity(String i){
        if(txtQuantity != null){
            ElementAction.clear(txtQuantity, "Quantity");
            ElementAction.type(txtQuantity, "Quantity", i);
        }
    }
    public void clickAddToCart(){
        if(btnAddToCart != null){
            Common.sleep(1);
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
    //Select a size
    public void selectSize(String size){
        if(size == "xxl" || size == "XXL"){
            sizes.get(0).click();
        }else if(size == "xl" || size == "XL"){
            sizes.get(1).click();
        }else if(size == "l" || size == "L"){
            sizes.get(2).click();
        }else if(size == "m" || size == "M"){
            sizes.get(3).click();
        }else if(size == "s" || size == "S"){
            sizes.get(4).click();
        }else{
            sizes.get(5).click();
        }
    }
}
