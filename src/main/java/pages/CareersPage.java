package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    public static WebDriver driver;

    // Constructor
    public CareersPage(WebDriver driver){

        this.driver = driver;
    }

    // Locators

    private By openPositionsBTN = By.xpath("//*[@id='content']/div[1]/div/div[1]/div/section/div/a/button");
    private By locationSelectBy = By.id("get_location");
    private By experiencedQA = By.xpath("//*[@id=\"content\"]/section/div[2]/article[2]/div");
    private By rigtArticale = By.xpath("//*[@id='post-1501']/div/div[2]/div[1]/div[1]/div[1]");
    private By leftArticale = By.xpath("//*[@id='post-1501']/div/div[2]/div[1]/div[1]/div[2]");
    private By pullRigtArticale = By.xpath("//*[@id='post-1501']/div/div[2]/div[1]/div[2]/div[1]");
    private By pullLeftArticale = By.xpath("//*[@id='post-1501']/div/div[2]/div[1]/div[2]/div[2]");

    private By applyBTN = By.xpath("//input[@value='Apply']");
    private By nameBox = By.id("cf-1");
    private By emailBox = By.id("cf-2");
    private By mobilelBox = By.id("cf-3");

    private By uploadCVBOX = By.id("uploadtextfield");
    private By agreementCheck = By.id("adConsentChx");
    private By sendBTN = By.xpath("//input[@value='Send']");

    private By invalidemailText = By.xpath("//*[@id='wpcf7-f880-o1']/form/p[3]/span/span");


    // Actions

    public void openCheckPositionPage(){

        driver.findElement(openPositionsBTN).click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void selectLocation(String value){

        Select locationSelect = new Select(driver.findElement(locationSelectBy));
        locationSelect.selectByValue(value);

    }

    public void OpenAutomationQA(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.visibilityOfElementLocated(experiencedQA));
        driver.findElement(experiencedQA).click();
    }

    public boolean isArticaleExist(String value){

        int foundElementsCount = 0;
        switch (value){
            case "1":
                foundElementsCount = driver.findElements(rigtArticale).size();
                break;
            case "2" :
                foundElementsCount = driver.findElements(leftArticale).size();
                break;
            case "3" :
                foundElementsCount = driver.findElements(pullRigtArticale).size();
                break;
            case "4" :
                foundElementsCount = driver.findElements(pullLeftArticale).size();
                break;
        }

        if (foundElementsCount > 0) {
            System.out.println("Element Is Exist");
            return true;
        }else {
            System.out.println("Element Is not Exist");
            return false;
        }

    }

    public boolean isApplyButtonDisplayed(){
        int foundElementsCount = driver.findElements(applyBTN).size();
        if (foundElementsCount > 0) {
            System.out.println("Element Is Exist");
            return true;
        }else {
            System.out.println("Element Is not Exist");
            return false;
        }
    }

    public void applyForAJob(String name , String email, String mobile , String file){
        driver.findElement(applyBTN).click();
        driver.findElement(nameBox).sendKeys(name);
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(mobilelBox).sendKeys(mobile);
        driver.findElement(uploadCVBOX).sendKeys(file);
        driver.findElement(agreementCheck).click();
        driver.findElement(sendBTN).click();

    }

    public String getInvalidEmailText() throws InterruptedException {

        Alert alert = driver.switchTo().alert();
        // Accepting alert
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidemailText));
        return driver.findElement(invalidemailText).getText();
    }
}
