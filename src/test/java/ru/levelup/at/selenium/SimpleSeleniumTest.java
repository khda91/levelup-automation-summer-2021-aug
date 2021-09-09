package ru.levelup.at.selenium;

import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SimpleSeleniumTest {

    @Test
    public void simpleSeleniumTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/drivers/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Google");
        SleepUtil.sleep(3000);
        driver.quit();
    }

    @Test
    public void simpleSeleniumWithBrowserSelectTest() {
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("mac")) {
            if ("chrome".equalsIgnoreCase(System.getProperty("browserName"))) {
                System.setProperty("webdriver.chrome.driver",
                    "src/test/resources/selenium/drivers/chrome/chromedriver");
            } else if ("opera".equalsIgnoreCase(System.getProperty("browserName"))) {
                System.setProperty("webdriver.opera.driver",
                    "src/test/resources/selenium/drivers/opera/operadriver");
            }
        } else if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("windows")) {
            System.setProperty("webdriver.chrome.driver",
                "src/test/resources/selenium/drivers/chrome/chromedriver.exe");
        }
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Google");
        SleepUtil.sleep(3000);
        driver.quit();
    }

    @Test
    public void simpleSeleniumWithWebDriverManagerTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, "Google");
        SleepUtil.sleep(3000);
        driver.quit();
    }
}
