package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SummerDresses {
    public static String summerDressesURL="http://automationpractice.com/index.php?id_category=11&controller=category";

    // Elements selectors
    private static String whiteColorCssSelector= "#color_40";
    private static String plusSigNXPath= "//a[@class='btn btn-default button-plus product_quantity_up']//span";
    private static String sizeId="group_1";
    private static String addToCartXPath="//span[contains(text(),'Add to cart')]";
    private static String clickCartXPath="//b[contains(text(),'Cart')]";
    private static String closeOrderWindowXPath="//span[@class='cross']";

    //Web Elements getters

    public static WebElement getWhiteColor(WebDriver driver){
        return driver.findElement(By.cssSelector(whiteColorCssSelector));
    }
    public static WebElement getPlusSign(WebDriver driver){
        return driver.findElement(By.xpath(plusSigNXPath));
    }
    public static WebElement getSize(WebDriver driver){
        return driver.findElement(By.id(sizeId));
    }
    public static WebElement getAddToCart(WebDriver driver){
        return driver.findElement(By.xpath(addToCartXPath));
    }
    public static WebElement getClickCart(WebDriver driver){
        return driver.findElement(By.xpath(clickCartXPath));
    }
    public static WebElement getCloseOrderWindow(WebDriver driver){
        return driver.findElement(By.xpath(closeOrderWindowXPath));
    }

    //Methods
    public static void clickWhiteColor(WebDriver driver){
        getWhiteColor(driver).sendKeys(Keys.DOWN);
        getWhiteColor(driver).click();
    }
    public static void clickPlusSign(WebDriver driver){
        getPlusSign(driver).click();
    }
    public static void selectSize(WebDriver driver, String size){
        Select selectSize=new Select(getSize(driver));
        selectSize.selectByVisibleText(size);
    }
    public static void clickAddToCart(WebDriver driver){
        getAddToCart(driver).click();
    }
    public static void clickCloseOrderWindow(WebDriver driver){
        getCloseOrderWindow(driver).click();
    }
    public static void clickCart(WebDriver driver){
        Actions action=new Actions(driver);
        action.moveToElement(getClickCart(driver)).perform();
        getClickCart(driver).click();
    }
}
