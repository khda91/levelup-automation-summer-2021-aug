package ru.levelup.at.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumMultipleWindowsCloseTest {

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
        SleepUtil.sleep(1000);

        new Actions(driver)
            .keyDown(Keys.COMMAND)
            .sendKeys("t")
            .build()
            .perform();
        System.out.println(driver.getWindowHandle());
        SleepUtil.sleep(3000);
        new Actions(driver)
            .keyDown(Keys.CONTROL)
            .sendKeys("N")
            .build()
            .perform();
        System.out.println(driver.getWindowHandles());
        SleepUtil.sleep(3000);
        driver.close();
    }

    @AfterMethod
    public void tearDown() {
        SleepUtil.sleep(3000);
        driver.quit();
    }
}
