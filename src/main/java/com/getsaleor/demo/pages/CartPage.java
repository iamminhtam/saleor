package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import com.getsaleor.demo.BaseStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Common;
import utilities.ElementAction;
import utilities.LogUtils;

import java.util.List;

public class CartPage extends BasePage {

    /*
    ELEMENTS
     */
    @FindBy(css = "span.badge")
    WebElement iconBadge;

    @FindBy(css = "a.cart__icon")
    WebElement iconCart;

    @FindBy(css = "div.cart__line__product p")
    List<WebElement> txtProductName;

    @FindBy(id = "id_quantity")
    List<WebElement> inputQuantity;

    @FindBy(css = "div.cart-item-price p")
    List<WebElement> txtPrice;

    @FindBy(css = "h3.cart-subtotal")
    WebElement cartSubTotal;

    @FindBy(css = "div.cart__line__quantity")
    WebElement space;

    @FindBy(css = "div.cart__empty h2")
    WebElement txtInfo;

    @FindBy(css = "span.cart-item-delete")
    WebElement bin;

    @FindBy(css = "a.cart__submit")
    WebElement btnCheckOut;
    /*
    PUBLIC ACTION
     */
    public void clickToSpace(){
        ElementAction.click(space, "Space");
    }
    public int getNumberProduct(){
        int number = 0;
        if(iconBadge != null){
            number = Integer.parseInt(iconBadge.getText());
        }
        return number;
    }
    public void goToCart(){
        if( iconCart != null) {
            ElementAction.click(iconCart, "Cart");
        }
    }
    public String[] getProductName() {
        if (txtProductName.size() != 0) {
            String[] name = new String[txtProductName.size()];
            for (int i = 0; i < txtProductName.size(); i++) {
                name[i] = Common.getTextNode(txtProductName.get(i));
            }
            return name;
        } else {
            return null;
        }
    }
    public void typeQuantity(String number){
        String quantity = String.valueOf(number);
        if(inputQuantity != null){
            for(int i = 0; i<inputQuantity.size(); i++){
                LogUtils.info(inputQuantity.get(i).getText());
                ElementAction.type(inputQuantity.get(i), "Quantity", quantity);
            }
        }
    }
    public String[] getPrice(){
        if (txtPrice.size() != 0) {
            String[] price = new String[txtPrice.size()];
            for (int i = 0; i < txtPrice.size(); i++) {
                price[i] = Common.getTextNode(txtPrice.get(i));
            }
            return price;
        } else {
            return null;
        }
    }
    public void getSubTotal(){
        if(cartSubTotal != null){
            Common.getTextNode(cartSubTotal);
        }
    }

    public String getInfo(){
        String info = "";
        if(txtInfo != null){
            info = txtInfo.getText();
        }
        return info;
    }
    public void clickBin(){
        ElementAction.click(bin, "Bin");
    }

    public void clickCheckOut(){
        if(btnCheckOut != null){
            ElementAction.click(btnCheckOut, "CheckOut");
        }
    }
}
