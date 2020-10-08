package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBar {
    //Elements selectors
    private static String sarchBarXPath="//input[@id='search_query_top']";
    private static String amountOfProductsResultXPath="//span[@class='heading-counter']";


    //WebElements getters
    public static WebElement searchBar(WebDriver driver){
        return driver.findElement(By.xpath(sarchBarXPath));
    }
    public static WebElement  amountOfProductsResult(WebDriver driver){
        return driver.findElement(By.xpath(amountOfProductsResultXPath));
    }

    //Methods
    public static void clickSearchBar(WebDriver driver){
        searchBar(driver).click();
    }

    public static void insertValueInASearchBar(WebDriver driver, String value){
        clickSearchBar(driver);
        searchBar(driver).sendKeys(value);
        searchBar(driver).sendKeys(Keys.ENTER);

    }
    public static String getamountOfProductsResult(WebDriver driver){
      return  amountOfProductsResult(driver).getText();
    }
}
