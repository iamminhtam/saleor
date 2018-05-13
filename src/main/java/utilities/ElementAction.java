package utilities;

import org.openqa.selenium.WebElement;

public class ElementAction {
    //Hàm click vào một đối tượng
    public static void click(WebElement element, String elementName){
        if(element != null){
            element.click();
            System.out.println(String.format("Click %s", elementName));
        }
    }
    //Hàm nhập input cho một đối tượng
    public static void type(WebElement element, String elementName, String value){
        if(element != null){
            element.clear();
            element.sendKeys(value);
            System.out.println(String.format("Type '%s' into '%s' input", value, elementName));
        }
    }
    //Hàm xóa input cho một đối tượng textbox
    public  static void clear(WebElement element, String elementName){
        if(element != null){
            element.clear();
            System.out.println(String.format("Clear %s", elementName));
        }
    }
}
