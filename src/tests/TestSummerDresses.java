package tests;

import objects.Cart;
import objects.SummerDresses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestSummerDresses {
    private static WebDriver driver = new ChromeDriver();

    private static SoftAssert sa;
    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public static void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sa = new SoftAssert();

    }
    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public static void checkIfCartMatches() throws InterruptedException {
        driver.get(SummerDresses.summerDressesURL);
        SummerDresses.clickWhiteColor(driver);
        SummerDresses.clickPlusSign(driver);
        SummerDresses.selectSize(driver, "M");
        SummerDresses.clickAddToCart(driver);
        Thread.sleep(3000);
        SummerDresses.clickCloseOrderWindow(driver);
        Thread.sleep(3000);
        SummerDresses.clickCart(driver);
        Cart.dressNameAsString(driver);
        Cart.sizeAndColorAsString(driver);
        Cart.quantityAsString(driver);
        String dressName= "Printed Summer Dress";
        String sizeAndColor="Color : White, Size : M";
        String quantity= "2";
        sa.assertEquals(Cart.dressNameAsString(driver),dressName);
        sa.assertEquals(Cart.sizeAndColorAsString(driver), sizeAndColor);
        sa.assertEquals(Cart.quantityAsString(driver), quantity);
        sa.assertAll();
    }
}
