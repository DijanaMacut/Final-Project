package tests;

import objects.Home;
import objects.SearchBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSearchBarResults {
    private static WebDriver driver = new ChromeDriver();


    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeMethod
    public static void setDriver() {
        driver.get(Home.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SearchBar.insertValueInASearchBar(driver,"yellow");
    }


    @AfterClass
    public static void closeDriver() {
        driver.close();
    }


    @Test
    public static void amountOfProducts(){
        String expected="3 results have been found.";
        Assert.assertEquals(SearchBar.getamountOfProductsResult(driver),expected);
    }
    @Test
    public static void colorOfChosenProduct(){
        boolean havekeyword=false;
        List<WebElement>colorContainer=driver.findElements(By.className("color_to_pick_list"));
        for(int i=0;i<colorContainer.size();i++){
            List<WebElement>allColors=driver.findElements(By.className("color_pick"));
            for(int j=0;j< allColors.size();j++){
                if(allColors.get(j).getAttribute("style").contains("background: rgb(241, 196, 15);")){
                    havekeyword=true;
                }
            }
        }
        Assert.assertTrue(havekeyword);
    }


}
