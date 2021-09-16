package ru.levelup.at.selenium.base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumCssSelectorsTest extends SeleniumBaseTest {

    @Test
    public void idDomSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.id("gbwa"));
        WebElement gbwa = driver.findElement(By.cssSelector("#gbwa"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
    }

    @Test
    public void classNameCssSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.className("gLFyf"));
        WebElement gbwa = driver.findElement(By.cssSelector(".gLFyf"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("title"), "Поиск");
    }

    @Test
    public void nameCssSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.name("q"));
        WebElement gbwa = driver.findElement(By.cssSelector("[name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void tagNameCssSelectorTest() {
        SleepUtil.sleep(1000);
        // var gbwa = driver.findElements(By.tagName("input"));
        var gbwa = driver.findElements(By.cssSelector("input"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.size() > 2);
    }

    @Test
    public void anotherAttributeCssSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.cssSelector("[value='Мне повезёт!']"));
        SleepUtil.sleep(1500);
        assertEquals(gbwa.getAttribute("aria-label"), "Мне повезёт!");
    }

    @Test
    public void combinedCssSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.cssSelector("input[name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void combinedWithParentCssSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.cssSelector("div.a4bIc input[name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }
}
