package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Common {
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTextNode(WebElement element){
        String text = element.getText().trim();
        List<WebElement> children = element.findElements(By.xpath("./*"));
        for (WebElement child : children)
        {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }
}
