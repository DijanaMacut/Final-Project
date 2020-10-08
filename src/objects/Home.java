package objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {

    
    public static String url="http://automationpractice.com/index.php";
    //Elements selectors
    private static String hoverWomenXPath= "//a[@class='sf-with-ul'][contains(text(),'Women')]";
    private static String summerDressesFromHoveringWomenXPath= "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
    private static String hoverDressesXPath= "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]";
    private static String summerDressesFromHoveringDressesXPath="//li[@class='sfHover']//a[contains(text(),'Summer Dresses')]";


    //Web Elements getters
    public static WebElement getHoverWomen(WebDriver driver){
        return driver.findElement(By.xpath(hoverWomenXPath));

    }
    public static WebElement getSummerDressesFromHoveringWomen(WebDriver driver){
        return driver.findElement(By.xpath(summerDressesFromHoveringWomenXPath));
    }
    public static WebElement getHoverDresses(WebDriver driver){
        return driver.findElement(By.xpath(hoverDressesXPath));
    }
    public static WebElement getsummerDressesFromHoveringDresses(WebDriver driver){
        return driver.findElement(By.xpath(summerDressesFromHoveringDressesXPath));
    }


    //Methods
    public static void actionHoverWomen(WebDriver driver){
        Actions action= new Actions(driver);
        action.moveToElement(getHoverWomen(driver)).perform();
    }
    public static void clickSummerDressesFromHoveringWomen(WebDriver driver){
        actionHoverWomen(driver);
        getSummerDressesFromHoveringWomen(driver).click();

    }
    public static String clickSummerDressesFromHoveringWomenURL(WebDriver driver){
        clickSummerDressesFromHoveringWomen(driver);
        return driver.getCurrentUrl();
    }
    public static void actionHoverDresses(WebDriver driver){
        Actions action=new Actions(driver);
        action.moveToElement(getHoverDresses(driver)).perform();
    }
    public static void clickSummerDressesFromHoveringDresses(WebDriver driver){
        actionHoverDresses(driver);
        getsummerDressesFromHoveringDresses(driver).click();
    }
    public static String clickSummerDressesFromHoveringDressesURL(WebDriver driver){
        clickSummerDressesFromHoveringDresses(driver);
        return driver.getCurrentUrl();
    }

}
