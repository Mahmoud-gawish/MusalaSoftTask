package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceBookPage {

    public static WebDriver driver;

    // Constructor
    public FaceBookPage(WebDriver driver){

        this.driver = driver;
    }

    private By MusalaImg = By.xpath("//*[@id='mount_0_0_LJ']/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div/a/div/svg/g/image");



    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getProfilePicAttribute(){

       return driver.findElement(MusalaImg).getAttribute("xlink:href");

    }

}
