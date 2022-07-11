package testCases;

import base.TestBase;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompanyPage;
import pages.FaceBookPage;
import pages.HomePage;

public class CompanyTests extends TestBase {

    // Variables
    HomePage homePageObj;
    CompanyPage companyPageObj;
    FaceBookPage faceBookPageObj;


    @BeforeMethod
    public void BeforeMethod(){
        startDriver("chrome");
        homePageObj = new HomePage(driver);
        companyPageObj = new CompanyPage(driver);
        faceBookPageObj = new FaceBookPage(driver);
    }

    @Test
    public void checkCompanyPage_Test_2(){
        homePageObj.openCompanyPage();
        String url = companyPageObj.getCurrentURL();
        Assert.assertEquals(url,"https://www.musala.com/company/");

        // check if LeaderShip exist
        boolean falg =  companyPageObj.isLeaderShipExist();
        Assert.assertEquals(falg,true);

        // open facebook page
        companyPageObj.openFaceBookPage();
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com/MusalaSoft?fref=ts");
        url = faceBookPageObj.getCurrentURL();
        Assert.assertEquals(url,"https://www.facebook.com/MusalaSoft?fref=ts");


        String IMG = faceBookPageObj.getProfilePicAttribute();
        System.out.println("the image att is : " + IMG);
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("test case finished ");
        stopDriver();
    }
}
