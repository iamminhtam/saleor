package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFinder {

    private static WebDriver driver;

    public static void initializeDriver(WebDriver pDriver){
        driver = pDriver;
    }
//    public static WebElement findElementById(String id){
//        return driver.findElement(By.id(id));
//    }

}
