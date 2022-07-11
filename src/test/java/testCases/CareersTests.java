package testCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.CompanyPage;
import pages.FaceBookPage;
import pages.HomePage;

public class CareersTests extends TestBase {

    HomePage homePageObj;
    CareersPage careersPageObj;

    @BeforeMethod
    public void BeforeMethod(){
        startDriver("chrome");
        homePageObj = new HomePage(driver);
        careersPageObj = new CareersPage(driver);

    }

    @Test
    public void checkCareesPage_Test_3() throws InterruptedException {
        homePageObj.openCareersPage();
        careersPageObj.openCheckPositionPage();

        String url = careersPageObj.getCurrentURL();
        Assert.assertEquals(url,"https://www.musala.com/careers/join-us/");

        careersPageObj.selectLocation("Anywhere");
        careersPageObj.OpenAutomationQA();
        boolean falg = careersPageObj.isArticaleExist("1");
        Assert.assertEquals(falg,true);
        falg = careersPageObj.isArticaleExist("2");
        Assert.assertEquals(falg,true);
        falg = careersPageObj.isArticaleExist("3");
        Assert.assertEquals(falg,true);
        falg = careersPageObj.isArticaleExist("4");
        Assert.assertEquals(falg,true);

        // verify that Apply Button is existed
        falg =  careersPageObj.isApplyButtonDisplayed();
        Assert.assertEquals(falg,true);

        careersPageObj.applyForAJob("testCase","mail@test","0127977955","C:\\newhtml.html");
        String emailTXt = careersPageObj.getInvalidEmailText();
        Assert.assertEquals(emailTXt,"The e-mail address entered is invalid.");

    }



    @AfterMethod
    public void AfterMethod() {
        System.out.println("test case finished ");
        stopDriver();
    }
}
