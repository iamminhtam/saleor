package com.getsaleor.demo.pages;

import com.getsaleor.demo.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementAction;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(){
        System.out.println("You are now on Home Page");
    }

    @FindBy(css = "ul.float-right li")
    List<WebElement> listItems;

    public void clickLogin(){
        ElementAction.click(listItems.get(2), "LOG IN");
    }

}
