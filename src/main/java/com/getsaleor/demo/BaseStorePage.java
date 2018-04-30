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

    public static String typeRandomNumberOfProduct(int i){
        Random random = new Random();
        int j=0;
        int numberProduct = 0;
        while(random.nextInt(i) != 0){
            numberProduct =  random.nextInt(i);
            j++;
        }
        String number = String.valueOf(numberProduct);
        return number;
    }
}
