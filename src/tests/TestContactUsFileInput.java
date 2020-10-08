package tests;

import objects.ContactUs;
import objects.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ReadFromFile;
import java.util.concurrent.TimeUnit;

public class TestContactUsFileInput {
    private static WebDriver driver = new ChromeDriver();
    private static SoftAssert sa=new SoftAssert();
    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeMethod
    public static void setDriver() {
        driver.get(Home.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
    @Test
    public static void dataInputFromFile() throws InterruptedException {
        ReadFromFile data= new ReadFromFile("TestData.xlsx");
        for (int i=1; i<=30;i++){
            //driver.get(Home.url);
            ContactUs.clickContactUs(driver);
            Thread.sleep(1000);
            ContactUs.selectHeading(driver,data.getCell(i,0));
            Thread.sleep(1000);
            ContactUs.inputUserEmail(driver,data.getCell(i, 1));
            Thread.sleep(1000);
            ContactUs.inputOrderReference(driver,data.getCell(i,2));
            Thread.sleep(1000);
            ContactUs.inputMessage(driver,data.getCell(i,3));
            Thread.sleep(1000);
            ContactUs.clickSendButton(driver);
            Thread.sleep(1000);
            sa.assertTrue(ContactUs.successfulSubmition(driver));
        }
        sa.assertAll();


    }
}
