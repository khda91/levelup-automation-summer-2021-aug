package ru.levelup.at.selenium;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SimpleSeleniumWithBeforeTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void simpleSeleniumTest() {
        driver.navigate().to("https://www.google.com/");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Google");
        SleepUtil.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
