package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementAction;

public class CheckOutPage extends BasePage{
    /*
    ELEMENTS
     */
    @FindBy(css = "header.checkout__header h1")
    WebElement txtCheckOut;
    @FindBy(css = "div.navbar__logo a")
    WebElement iconHome;


    /*
    PUBLIC ACTION
     */
    public String getHeader(){
        String header = "";
        if(txtCheckOut!=null){
            header = txtCheckOut.getText();
        }
        return header;
    }
}
