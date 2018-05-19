package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Common;
import utilities.ElementAction;
import utilities.LogUtils;

public class LoginPage extends BasePage {
    public LoginPage(){
        LogUtils.info("You are now on Login Page");
    }
    /*
    ELEMENTS
     */
    @FindBy(id = "id_username")
    private WebElement txtUsername;

    @FindBy(id = "id_password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[contains(@class, 'primary')]")
    private WebElement btnLogin;

    @FindBy(css = "div.alert-danger")
    private WebElement errorMessage;

    /*
    PUBLIC ACTIONS
     */
    public LoginPage clearUsername(){
        ElementAction.clear(txtUsername, "Username");
        return this;
    }
    public LoginPage clearPassword(){
        ElementAction.clear(txtPassword, "Password");
        return this;
    }
    public LoginPage typeUsername(String username){
        ElementAction.type(txtUsername, "Username", username);
        return this;
    }
    public LoginPage typePassword(String password){
        ElementAction.type(txtPassword, "Password", password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        ElementAction.click(btnLogin, "Log in");
        return this;
    }
    public String getErrorMessage(String msg){
        String actualErrorMessage = Common.getTextNode(errorMessage);
        boolean result = actualErrorMessage.equals(msg);
        String log = String.format(" [Expectation] See error message '%s': %b", msg,result);
        if (result) {
            LogUtils.info(log);
        } else {
            LogUtils.warn( log + String.format(" (actual: '%s", actualErrorMessage));
        }
        return actualErrorMessage;
    }
}
