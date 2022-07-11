package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyPage {

    public static WebDriver driver;

    // Constructor
    public CompanyPage(WebDriver driver){

        this.driver = driver;
    }

    // Locators
    private By leaderShipSection = By.xpath("//section[@class='company-members']");
    private By faceBookBTN = By.xpath("/html/body/footer/div/div/a[4]");



    // Actions
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean isLeaderShipExist(){

       int foundElementsCount = driver.findElements(leaderShipSection).size();
        if (foundElementsCount > 0) {
            System.out.println("Element Is Exist");
            return true;
        }else {
            System.out.println("Element Is not Exist");
            return false;
        }

    }

    public void openFaceBookPage(){

        WebElement clickFB = driver.findElement(faceBookBTN);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickFB);

    }


}
