package ru.levelup.at.selenium.base;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumExplicitVsImplicitWaitTest extends SeleniumBaseTest {

    WebDriverWait wait;

    @Test
    public void seleniumGoogleSearchHelpWithExplicitVsImplicitWaitTest1() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.findElement(By.name("q")).sendKeys("book");

        List<WebElement> dropdownPossibleSearchResultsList;
        long startTime = System.currentTimeMillis();
        try {
            dropdownPossibleSearchResultsList = wait.until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.cssSelector("ul[role='listbox'] > li1"), 3));
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Search element %d ms%n", (endTime - startTime));
        }
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }

    @Test
    public void seleniumGoogleSearchHelpWithExplicitVsImplicitWaitTest2() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 21);
        driver.findElement(By.name("q")).sendKeys("book");

        List<WebElement> dropdownPossibleSearchResultsList;
        long startTime = System.currentTimeMillis();
        try {
            dropdownPossibleSearchResultsList = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.cssSelector("ul[role='listbox'] > li1"), 3));
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Search element %d ms%n", (endTime - startTime));
        }
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }

    @Test
    // Правильный вариант совместного использования явных и неявных ожиданий
    public void seleniumGoogleSearchHelpWithExplicitVsImplicitWaitTest3() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 21);
        driver.findElement(By.name("q")).sendKeys("book");

        List<WebElement> dropdownPossibleSearchResultsList;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        try {
            dropdownPossibleSearchResultsList = wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.cssSelector("ul[role='listbox'] > li1"), 3));
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.printf("Search element %d ms%n", (endTime - startTime));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        dropdownPossibleSearchResultsList.get(4).click();
        var searchResults = driver.findElements(By.xpath("//a/h3"));
        assertTrue(searchResults.get(0).isDisplayed());
    }
}
