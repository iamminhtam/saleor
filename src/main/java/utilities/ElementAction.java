package utilities;

import org.openqa.selenium.WebElement;

public class ElementAction {

    public static void click(WebElement element, String elementName){
        if(element != null){
            element.click();
            System.out.println(String.format("Click %s", elementName));
        }
    }

    public static void type(WebElement element, String elementName, String value){
        if( element != null){
            element.clear();
            element.sendKeys(value);
            System.out.println(String.format("Type '%s' into '%s' input", value, elementName));
        }
    }
}
