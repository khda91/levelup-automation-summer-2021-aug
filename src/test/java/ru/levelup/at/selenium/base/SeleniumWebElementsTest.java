package ru.levelup.at.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.util.Strings;
import ru.levelup.at.util.SleepUtil;

public class SeleniumWebElementsTest {

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
    public void seleniumFindElementSuccessOneElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        WebElement element = driver.findElement(By.cssSelector("input.gNO89b"));
        System.out.println("seleniumFindElementSuccessOneElementTest -> " + element.getAttribute("aria-label"));
        System.out.println();
    }

    @Test
    public void seleniumFindElementsSuccessOneElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        List<WebElement> element = driver.findElements(By.cssSelector("input.gNO89b"));
        System.out.println("seleniumFindElementsSuccessOneElementTest -> " + element.size());
        System.out.println("seleniumFindElementsSuccessOneElementTest -> " + element.get(0).getAttribute("aria-label"));
        System.out.println();
    }

    @Test
    public void seleniumFindElementSuccessMultipleElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//center/input"));
        System.out.println("seleniumFindElementSuccessMultipleElementTest -> " + element.getAttribute("aria-label"));
        System.out.println();
    }

    @Test
    public void seleniumFindElementsSuccessMultipleElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        List<WebElement> element = driver.findElements(By.xpath("//center/input"));
        System.out.println("seleniumFindElementsSuccessMultipleElementTest -> " + element.size());
        System.out.println("seleniumFindElementsSuccessMultipleElementTest -> "
            + element.stream().map(we -> we.getAttribute("aria-label")).collect(Collectors.joining()));
        System.out.println();
    }

    @Test
    public void seleniumFindElementNotFoundMultipleElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//center/inpu"));
        System.out.println("seleniumFindElementNotFoundMultipleElementTest -> " + element.getAttribute("aria-label"));
        System.out.println();
    }

    @Test
    public void seleniumFindElementsNotFoundMultipleElementTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        List<WebElement> element = driver.findElements(By.xpath("//center/inpu"));
        System.out.println("seleniumFindElementsNotFoundMultipleElementTest -> " + element.size());
        System.out.println("seleniumFindElementsNotFoundMultipleElementTest -> "
            + element.stream().map(we -> we.getAttribute("aria-label")).collect(Collectors.joining()));
        System.out.println();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
