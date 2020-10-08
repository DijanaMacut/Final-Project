package tests;

import objects.ContactUs;
import objects.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestContactUs {
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
    }


    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @Test
    public static void checkSubmition() throws InterruptedException {
        driver.get(Home.url);
        ContactUs.clickContactUs(driver);
        Thread.sleep(3000);
        ContactUs.selectHeading(driver, "Customer service");
        Thread.sleep(3000);
        ContactUs.inputUserEmail(driver,"dijana@mail.com");
        Thread.sleep(3000);
        ContactUs.inputOrderReference(driver,"1");
        Thread.sleep(5000);
        ContactUs.chooseAFile(driver,"C:\\Users\\pc\\Desktop\\Dijana Macut.pdf");
        Thread.sleep(3000);
        ContactUs.inputMessage(driver,"poruka");
        Thread.sleep(3000);
        ContactUs.clickSendButton(driver);
        Thread.sleep(3000);
        Assert.assertTrue(ContactUs.successfulSubmition(driver));
    }
}
