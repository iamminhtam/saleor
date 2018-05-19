package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Common;
import utilities.ElementAction;
import utilities.LogUtils;

public class RegisterPage extends BasePage{
    public RegisterPage(){
        LogUtils.info("You are now on Register Page");
    }
    /*
    ELEMENTS
     */
    @FindBy(id ="id_email")
    private WebElement txtEmail;

    @FindBy(id = "id_password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[contains(@class, 'primary')]")
    private WebElement btnCreateAccount;

    @FindBy(css = "div.alert-danger")
    private WebElement errorMessage;

    /*
    PUBLIC ACTION
     */
    public RegisterPage clearUsername(){
        ElementAction.clear(txtEmail, "Email");
        return this;
    }
    public RegisterPage clearPassword(){
        ElementAction.clear(txtPassword, "Password");
        return this;
    }
    public RegisterPage typeEmail(String email){
        ElementAction.type(txtEmail, "Email", email);
        return this;
    }
    public RegisterPage typePassword(String password){
        ElementAction.type(txtPassword, "Password", password);
        return this;
    }
    public RegisterPage clickCreateBtn(){
        ElementAction.click(btnCreateAccount, "Create an account");
        return this;
    }
    public String getErrorMessage(){
        String msg = "";
        if(errorMessage != null) {
            msg = Common.getTextNode(errorMessage);
        }
        return msg;
    }
}
