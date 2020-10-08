package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
    //Elements selectors
    private static String contactUsXPath = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
    private static String selectHeadingId = "id_contact";
    private static String userEmailId = "email";
    private static String orderReferenceId = "id_order";
    private static String attachFileId = "fileUpload";
    private static String messageId = "message";
    private static String sendButtonXPath = "//span[contains(text(),'Send')]";
    private static String successfulSubmitionXPath = "//p[@class='alert alert-success']";

    //WebElements getters
    public static WebElement getContactUs(WebDriver driver) {
        return driver.findElement(By.xpath(contactUsXPath));
    }

    public static WebElement getSelectHeading(WebDriver driver) {
        return driver.findElement(By.id(selectHeadingId));
    }

    public static WebElement getUserEmail(WebDriver driver) {
        return driver.findElement(By.id(userEmailId));
    }

    public static WebElement getorderReference(WebDriver driver) {
        return driver.findElement(By.id(orderReferenceId));
    }

    public static WebElement getAttachFile(WebDriver driver) {
        return driver.findElement(By.id(attachFileId));
    }

    public static WebElement getMessage(WebDriver driver) {
        return driver.findElement(By.id(messageId));
    }

    public static WebElement getSendButton(WebDriver driver) {
        return driver.findElement(By.xpath(sendButtonXPath));
    }

    public static WebElement getSuccessfulSubmition(WebDriver driver) {
        return driver.findElement(By.xpath(successfulSubmitionXPath));
    }


    //Methods
    public static void clickContactUs(WebDriver driver) {
        getContactUs(driver).click();
    }

    public static void selectHeading(WebDriver driver, String chooseHeading) {
        Select heading = new Select(getSelectHeading(driver));
        heading.selectByVisibleText(chooseHeading);
    }

    public static void inputUserEmail(WebDriver driver, String inputUserEmail) {
        getUserEmail(driver).sendKeys(inputUserEmail);
    }

    public static void inputOrderReference(WebDriver driver, String orderReference) {
        getorderReference(driver).sendKeys(orderReference);
        getorderReference(driver).sendKeys(Keys.PAGE_DOWN);
    }

    public static void chooseAFile(WebDriver driver, String filePath) {
        getAttachFile(driver).sendKeys(filePath);
    }

    public static void inputMessage(WebDriver driver, String message) {
        getMessage(driver).sendKeys(message);
    }

    public static void clickSendButton(WebDriver driver) {
        getSendButton(driver).click();
    }

    public static boolean successfulSubmition(WebDriver driver) {
        if (getSuccessfulSubmition(driver).getText().contains("Your message has been successfully sent to our team.")) ;
        return true;
    }
}
