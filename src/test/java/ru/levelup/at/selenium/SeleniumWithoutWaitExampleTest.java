package ru.levelup.at.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumWithoutWaitExampleTest extends SeleniumBaseTest {

    @Test
    public void seleniumWithoutWaitTest() {
        driver.findElement(By.name("q")).sendKeys("book" + Keys.ENTER);
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertEquals(searchResults.get(1).getText(), "Новинки - BOOK.RU - современная электронная ...");
    }

    @Test
    public void seleniumGoogleSearchHelpWithoutWaitTest() {
        driver.findElement(By.name("q")).sendKeys("book");
        var dropdownPossibleSearchResultsList =
            driver.findElements(By.cssSelector("ul[role='listbox'] > li"));
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }

    @Test
    public void seleniumGoogleSearchHelpWithThreadSleepWaitTest() {
        driver.findElement(By.name("q")).sendKeys("book");
        SleepUtil.sleep(5000);
        var dropdownPossibleSearchResultsList =
            driver.findElements(By.cssSelector("ul[role='listbox'] > li"));
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }
}
