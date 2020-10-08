package tests;

import objects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NoTestNGTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       driver.get(Home.url);
        driver.manage().window().maximize();

      /* Home.clickSummerDressesFromHoveringWomen(driver);
        driver.navigate().back();
       Home.clickSummerDressesFromHoveringDresses(driver);*/
        /*driver.get(SummerDresses.summerDressesURL);
        driver.manage().window().maximize();
        SummerDresses.clickWhiteColor(driver);
        SummerDresses.clickPlusSign(driver);
        SummerDresses.selectSize(driver, "M");
        SummerDresses.clickAddToCart(driver);
        Thread.sleep(3000);
        SummerDresses.clickCloseOrderWindow(driver);
        Thread.sleep(3000);
        SummerDresses.clickCart(driver);
        System.out.println(Cart.dressNameAsString(driver));*/
       // SearchBar.insertValueInASearchBar(driver,"yellow");
        /*ContactUs.clickContactUs(driver);
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
        ContactUs.clickSendButton(driver);*/

     /*   SocialIcons.clickFacebook(driver);

        SocialIcons.clickYouTube(driver);

        SocialIcons.clickTwitter(driver);

        SocialIcons.clickGooglePlus(driver);*/

       // System.out.println( SocialIcons.facebookURL(driver));

            SocialIcons.clickFacebook(driver);
            SocialIcons.clickYouTube(driver);
            SocialIcons.clickTwitter(driver);
            SocialIcons.clickGooglePlus(driver);
            String parent = driver.getWindowHandle();
            Set<String> s = driver.getWindowHandles();
            Iterator<String> I1 = s.iterator();
            List<String> URLs=new ArrayList<>();
            while (I1.hasNext()) {
                String child_window = I1.next();
                if (!parent.equals(child_window)) {
                    String URL= driver.switchTo().window(child_window).getCurrentUrl();
                    URLs.add(URL);
                    driver.close();
                }
            }
        System.out.println(URLs.toString());
    }
}
