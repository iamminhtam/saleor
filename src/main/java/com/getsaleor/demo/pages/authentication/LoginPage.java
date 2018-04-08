package com.getsaleor.demo.pages.authentication;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementAction;

public class LoginPage extends BasePage {
    public LoginPage(){
        System.out.println("You are now on Login Page");
    }
    /*
    ELEMENTS
     */
    @FindBy(id = "id_username")
    private WebElement usernameInput;
    @FindBy(id = "id_password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn primary narrow']")
    WebElement loginBtn;

    /*
    PUBLIC ACTIONS
     */
    public LoginPage typeUsername(String username){
        ElementAction.type(usernameInput, "Username", username);
        return this;
    }
    public LoginPage typePassword(String password){
        ElementAction.type(passwordInput, "Password", password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        ElementAction.click(loginBtn, "Log in");
        return this;
    }


}
