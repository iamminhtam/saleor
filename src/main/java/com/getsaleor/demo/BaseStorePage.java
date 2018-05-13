package com.getsaleor.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public abstract class BaseStorePage {
    public BaseStorePage(){
        System.out.println("You are now on Store Page");
    }
    /*
    ELEMENTS
     */
    @FindBy(css = "#category-page img.img-responsive")
    List<WebElement> productList;

    /*
    ACTION
     */
    public void selectARandomProduct(){
        Random random = new Random();
        int i = random.nextInt(productList.size());
        productList.get(i).click();
    }

    public static String typeRandomQuantity(int i){
        int randomQuantity = 0;
        do{
            Random random = new Random();
            randomQuantity = random.nextInt(10);
        }while(randomQuantity == 0);
        return  String.valueOf(randomQuantity);
    }
    public static int typeQuatity(int i){
        Random random = new Random();
        int randomQuantity = random.nextInt(10);
        return randomQuantity;
    }

}
