package ru.levelup.at.selenium;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumImplicitWaitExampleTest extends SeleniumBaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void seleniumGoogleSearchHelpWithImplicitWaitTest() {
        driver.findElement(By.name("q")).sendKeys("book");
        var dropdownPossibleSearchResultsList =
            driver.findElements(By.cssSelector("ul[role='listbox'] > li"));
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }

    @Test
    public void youlaAbsencesOfElementTest() {
        driver.navigate().to("https://youla.ru");
        driver.findElement(By.cssSelector("[data-test-action='CategoriesClick']")).click();
        WebElement headerCategoriesElement =
            driver.findElement(By.cssSelector("[data-test-component='HeaderCategories']"));
        assertTrue(headerCategoriesElement.isDisplayed());
        driver.findElement(By.cssSelector("[data-test-action='CategoriesClick']")).click();
        headerCategoriesElement =
            driver.findElement(By.cssSelector("[data-test-component='HeaderCategories']"));
        assertFalse(headerCategoriesElement.isDisplayed());
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
