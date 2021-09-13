package ru.levelup.at.selenium;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumExplicitWaitExampleTest extends SeleniumBaseTest {

    WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void seleniumGoogleSearchHelpWithExplicitWaitTest() {
        driver.findElement(By.name("q")).sendKeys("book");
        var dropdownPossibleSearchResultsList =
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("ul[role='listbox'] > li"), 3));
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }

    @Test
    public void youlaAbsencesOfElementTest() {
        driver.navigate().to("https://youla.ru");
        SleepUtil.sleep(25000);
        driver.findElement(By.cssSelector("[data-test-action='CategoriesClick']")).click();
        WebElement headerCategoriesElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-test-component='HeaderCategories']")));
        assertTrue(headerCategoriesElement.isDisplayed());
        driver.findElement(By.cssSelector("[data-test-action='CategoriesClick']")).click();
        boolean headerCategoriesElementInvisible = wait.until(ExpectedConditions
            .invisibilityOfElementLocated(By.cssSelector("[data-test-component='HeaderCategories']")));
        assertTrue(headerCategoriesElementInvisible);
    }

    @Test
    public void ozonAbsencesOfElementTest() {
        driver.navigate().to("https://www.ozon.ru/");
        driver.findElement(By.xpath("//div[text()='Каталог']")).click();
        WebElement headerCategoriesElement =
            driver.findElement(By.xpath("//div[@data-widget='catalogMenu']/div[2]"));
        assertTrue(headerCategoriesElement.isDisplayed());
        driver.findElement(By.xpath("//div[text()='Каталог']")).click();
        headerCategoriesElement =
            driver.findElement(By.xpath("//div[@data-widget='catalogMenu']/div[2]"));
        assertFalse(headerCategoriesElement.isDisplayed());
    }
}
