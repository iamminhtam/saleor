package com.getsaleor.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.LogUtils;

import java.util.List;
import java.util.Random;

public abstract class BaseStorePage {
    public BaseStorePage(){
        LogUtils.info("You are now on Store Page");
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
        LogUtils.info(String.format("Select the %s nd product", String.valueOf(i)));
    }

    public static String typeRandomQuantity(int i){
        int randomQuantity = 0;
        do{
            Random random = new Random();
            randomQuantity = random.nextInt(10);
        }while(randomQuantity == 0);
        return  String.valueOf(randomQuantity);
    }
    public static int typeQuantity(int i){
        Random random = new Random();
        int randomQuantity = random.nextInt(10);
        return randomQuantity;
    }

    public void selectAProduct(int i){
        productList.get(i).click();
        LogUtils.info(String.format("Select the %s nd product", String.valueOf(i)));
    }

}
