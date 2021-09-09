package ru.levelup.at.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumDomSelectorsTest extends SeleniumBaseTest {

    @Test
    public void idDomSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.id("gbwa"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
    }

    @Test
    public void classNameDomSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.className("gLFyf"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("title"), "Поиск");
    }

    @Test
    public void nameDomSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.name("q"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void linkTextDomSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.linkText("Почта"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getText(), "Почта");
    }

    @Test
    public void linkTextDomSelectorNonLinkElementTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.linkText("Поиск в Google"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getText(), "Почта");
    }

    @Test
    public void partialLinkTextDomSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.partialLinkText("Карт"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getText(), "Картинки");
    }

    @Test
    public void tagNameDomSelectorTest() {
        SleepUtil.sleep(1000);
        var gbwa = driver.findElements(By.tagName("input"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.size() > 2);
    }
}
