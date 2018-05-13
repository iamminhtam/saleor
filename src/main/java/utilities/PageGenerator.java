package utilities;

import com.getsaleor.demo.BasePage;
import com.getsaleor.demo.BaseStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

    private static WebDriver driver;
    public static void initializeDriver(WebDriver pDriver){
        driver = pDriver;
    }
    // Java Generics to Create and return a New Page
    public static <TPage extends BasePage> TPage getInstance (Class<TPage> pageClass){
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    public static <TPage extends BaseStorePage> TPage getInstanceStorePage (Class<TPage> pageClass){
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
