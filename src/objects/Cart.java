package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
    //Elements Selectors
    public String cartURL= "http://automationpractice.com/index.php?controller=order";
    private static String dressNameXPath="//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
    private static String sizeAndColorXPath= "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/small[2]/a[1]";
    private static String quantityXPath="//input[@name='quantity_6_41_0_0']";

    //Web Elements getters
    public static WebElement getDressName(WebDriver driver){
        return driver.findElement(By.xpath(dressNameXPath));
    }
    public static WebElement getSizeAndColor(WebDriver driver){
        return driver.findElement(By.xpath(sizeAndColorXPath));
    }
    public static WebElement getQuantity(WebDriver driver){
        return driver.findElement(By.xpath(quantityXPath));
    }

    //Methods
    public static String dressNameAsString(WebDriver driver){
        return getDressName(driver).getText();
    }
    public static String sizeAndColorAsString(WebDriver driver){
        return getSizeAndColor(driver).getText();
    }
    public static String quantityAsString(WebDriver driver){
        return getQuantity(driver).getAttribute("value");
    }

}
