package ru.levelup.at.selenium.page.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseSeleniumPageObjectTest {

    protected WebDriver driver;
    public static WebDriver driverStatic;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(new ChromeOptions()
            .setHeadless(Boolean.parseBoolean(System.getProperty("headless", "false"))));
        //        new FirefoxDriver(new FirefoxOptions()
        //            .setHeadless(true));
        // driverStatic = driver;
        context.setAttribute("web_driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        // driverStatic = null;
    }
}
