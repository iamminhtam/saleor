package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Common;
import utilities.ElementAction;
import utilities.LogUtils;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(){
        LogUtils.info("You are now on Home Page");
    }
    /*
    ELEMENTS
     */
    @FindBy(linkText = "Register")
    private  WebElement linkRegister;

    @FindBy(linkText = "Log in")
    private WebElement logInLink;

    @FindBy(css = "ul.float-right li>a")
    private List<WebElement> goToRightNav;

    @FindBy(linkText = "Log out")
    private WebElement logOutLink;

    @FindBy(css="div.alert-success")
    private WebElement messageSuccess;

    @FindBy(css ="ul.menu li.menu__item.nav-item")
    private List<WebElement> menu;
    /*
    PUBLIC ACTIONS
     */
    public void clickRegister(){
        if(linkRegister != null){
            ElementAction.click(linkRegister, "REGISTER");
        }
    }
    public void clickLogin(){
        if(logInLink != null){
            ElementAction.click(logInLink, "LOG IN");
        }
    }

    public void clickLogout(){
        if(logOutLink != null){
            ElementAction.click(logOutLink, "LOG OUT");
        }
    }
    public String[] getGoToRightNav(){
        String[] items = new String[goToRightNav.size()];
        for(int i = 0; i<goToRightNav.size(); i++){
            items[i] = goToRightNav.get(i).getText();
        }
        return items;
    }

    public String getMessageWhenLogout(){
        return Common.getTextNode(messageSuccess);
    }

    public void clickApparelLink(){
        if(menu != null){
            ElementAction.click(menu.get(0), "Apparel");
            LogUtils.info("Go to Apparel Page");
        }
    }

    public String getMessageWhenRegister(){
        return Common.getTextNode(messageSuccess);
    }
}
