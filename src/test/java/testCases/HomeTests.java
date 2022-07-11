package testCases;

import base.TestBase;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import testData.TestData;

import java.io.IOException;


public class HomeTests extends TestBase {

    // Variables
    HomePage homePageObj;


    @BeforeMethod
    public void BeforeMethod(){
        startDriver("chrome");
        homePageObj = new HomePage(driver);
    }

    @DataProvider(name = "getContactUsData")
    public Object[][] getContactUsData() throws InvalidFormatException, IOException {

        Object[][] data = TestData.fetchData("./src/test/resources/TestDataFiles/TestData.xlsx", "test_checkInvalidEmailFormat");
        return data;
    }

    @Test(dataProvider = "getContactUsData")
    public void test_checkInvalidEmailFormat(String name, String email, String mobile, String subject, String message) throws InterruptedException {

      homePageObj.addContact(name,email,mobile,subject,message);
      String emailTXt = homePageObj.getInvalidEmailText();
      Assert.assertEquals(emailTXt,"The e-mail address entered is invalid.");


    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("test case finished ");
        stopDriver();
    }

}
