package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;


public class HomePage {

    public static WebDriver driver;
    public Properties properties;

    // Constructor
    public HomePage(WebDriver driver){

        this.driver = driver;

    }

    // Elements
    private By contactUsBTN = By.xpath("//html/body/main/section[2]/div/div/div/a[1]/button");
    private By nameBox = By.id("cf-1");
    private By emailBox = By.id("cf-2");
    private By mobileBox = By.id("cf-3");
    private By subjectBox = By.id("cf-4");
    private By messageBox = By.id("cf-5");
    private By sendBTN = By.xpath("//input[@value='Send']");
    private By contactUsText = By.xpath("//h2[text() ='Contact Us']");

    private By invalidemailText = By.xpath("//*[@id='wpcf7-f875-o1']/form/p[2]/span/span");

    private By companyPageBTN = By.xpath("//*[@id='menu-main-nav-1']/li[1]/a");
    private By careersPageBTN = By.xpath("//*[@id='menu-main-nav-1']/li[5]/a");


    /// Actions ///


    public void addContact(String name, String email, String mobile, String subject, String message){
        WebElement clickContact = driver.findElement(contactUsBTN);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickContact);

        driver.findElement(nameBox).sendKeys(name);
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(mobileBox).sendKeys(mobile);
        driver.findElement(subjectBox).sendKeys(subject);
        driver.findElement(messageBox).sendKeys(message);
        driver.findElement(sendBTN).click();

    }

    public String getInvalidEmailText() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidemailText));
        return driver.findElement(invalidemailText).getText();
    }

    public void openCompanyPage(){

      driver.findElement(companyPageBTN).click();
    }

    public void openCareersPage(){

        driver.findElement(careersPageBTN).click();
    }



}
