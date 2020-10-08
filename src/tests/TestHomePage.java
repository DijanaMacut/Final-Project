package tests;

import objects.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class TestHomePage {

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
    public static void checkHoverWomenURLChange() {

        driver.get(Home.url);
        sa.assertEquals(Home.clickSummerDressesFromHoveringWomenURL(driver), "http://automationpractice.com/index.php?id_category=11&controller=category");
        sa.assertAll();
    }

    @Test
    public static void checkHoverDressesURLChange() {

        driver.get(Home.url);
        sa.assertEquals(Home.clickSummerDressesFromHoveringDressesURL(driver), "http://automationpractice.com/index.php?id_category=11&controller=category");
        sa.assertAll();
    }
    @Test
    public static void leadingToGoalPage(){

        String goalPageURL="http://automationpractice.com/index.php?id_category=11&controller=category";
        sa.assertEquals(Home.clickSummerDressesFromHoveringWomenURL(driver), goalPageURL);
        driver.navigate().back();
        sa.assertEquals(Home.clickSummerDressesFromHoveringDressesURL(driver), goalPageURL);
       // sa.assertEquals(Home.clickSummerDressesFromHoveringDressesURL(driver),Home.clickSummerDressesFromHoveringWomenURL(driver));
        sa.assertAll();
    }


}