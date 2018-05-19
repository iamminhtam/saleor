package utilities;

import org.openqa.selenium.WebElement;

public class ElementAction {
    //Hàm click vào một đối tượng
    public static void click(WebElement element, String elementName){
        if(element != null){
            element.click();
            LogUtils.info(String.format("Click %s", elementName));
        }
    }
    //Hàm nhập input cho một đối tượng
    public static void type(WebElement element, String elementName, String value){
        if(element != null){
            element.clear();
            element.sendKeys(value);
            LogUtils.info(String.format("Type '%s' into '%s' input", value, elementName));
        }
    }
    //Hàm xóa input cho một đối tượng textbox
    public  static void clear(WebElement element, String elementName){
        if(element != null){
            element.clear();
            LogUtils.info(String.format("Clear %s", elementName));
        }
    }
}
