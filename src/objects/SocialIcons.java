package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialIcons {
    //Elements selectors
    private static String facebookXPath="//li[@class='facebook']//a";
    private static String twitterXPath="//li[@class='twitter']//a";
    private static String youTubeXPath="//li[@class='twitter']//a";
    private static String googlePLusXPath="//li[@class='google-plus']//a";


    //Web Elements getters
    public static WebElement getFacebook(WebDriver driver){
        return driver.findElement(By.xpath(facebookXPath));
    }
    public static WebElement getTwitter(WebDriver driver){
        return driver.findElement(By.xpath(twitterXPath));
    }
    public static WebElement getYouTube(WebDriver driver){
        return driver.findElement(By.xpath(youTubeXPath));
    }
    public static WebElement getGooglePlus(WebDriver driver){
        return driver.findElement(By.xpath(googlePLusXPath));
    }

    //Methods
    public static void clickFacebook(WebDriver driver){
        getFacebook(driver).click();
    }
    public static void clickTwitter(WebDriver driver){
        getTwitter(driver).click();
    }
    public static void clickYouTube(WebDriver driver){

        getYouTube(driver).click();
    }
    public static void clickGooglePlus(WebDriver driver){
        getGooglePlus(driver).click();
    }
 
}
