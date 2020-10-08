package tests;

import objects.Home;
import objects.SocialIcons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestSocialIcons {
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

    @AfterMethod
    public static void closeDriver() {
        driver.quit();
    }

    @Test
    public static void checkIfURLMathes() throws InterruptedException {
        SoftAssert sa = new SoftAssert();
        List<String> expectedURLs = List.of("https://www.facebook.com/groups/525066904174158/", "https://twitter.com/seleniumfrmwrk", "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA", "https://plus.google.com/111979135243110831526/posts");
        SocialIcons.clickFacebook(driver);
        SocialIcons.clickYouTube(driver);
        SocialIcons.clickTwitter(driver);
        SocialIcons.clickGooglePlus(driver);
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                String URL = driver.switchTo().window(child_window).getCurrentUrl();
                for (int j = 0; j < expectedURLs.size(); j++) {
                    if (expectedURLs.get(j).equals(URL)) {
                        boolean URLMatch = true;
                        sa.assertTrue(URLMatch);
                    }
                }

            }
        }
        sa.assertAll();
    }


}
