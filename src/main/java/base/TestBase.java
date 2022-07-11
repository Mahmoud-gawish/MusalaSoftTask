package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties properties;
    public static WebDriver driver;

   // @BeforeMethod
    @Parameters({"browser"})
    public static void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().operatingSystem(OperatingSystem.WIN).setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.WIN).setup();
            driver = new FirefoxDriver();

        }
        driver.get("https://www.musala.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);


    }


    public void stopDriver() {
        driver.close();
        driver.quit();
    }
}
