package ru.levelup.at.selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.levelup.at.util.SleepUtil;

public class SeleniumXpathSelectorsTest extends SeleniumBaseTest {

    @Test
    public void idXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.id("gbwa"));
        // WebElement gbwa = driver.findElement(By.cssSelector("#gbwa"));
        WebElement gbwa = driver.findElement(By.xpath("//*[@id='gbwa']"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
    }

    @Test
    public void classNameXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.className("gLFyf"));
        // WebElement gbwa = driver.findElement(By.cssSelector(".gLFyf"));
        WebElement gbwa = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("title"), "Поиск");
    }

    @Test
    public void nameXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.name("q"));
        // WebElement gbwa = driver.findElement(By.cssSelector("[name='q']"));
        WebElement gbwa = driver.findElement(By.xpath("//*[@name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void tagNameXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // var gbwa = driver.findElements(By.tagName("input"));
        // var gbwa = driver.findElements(By.cssSelector("input"));
        var gbwa = driver.findElements(By.xpath("//input"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.size() > 2);
    }

    @Test
    public void anotherAttributeXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.cssSelector("[value='Мне повезёт!']"));
        WebElement gbwa = driver.findElement(By.xpath("//*[@value='Мне повезёт!']"));
        SleepUtil.sleep(1500);
        assertEquals(gbwa.getAttribute("aria-label"), "Мне повезёт!");
    }

    @Test
    public void combinedXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.cssSelector("input[name='q']"));
        WebElement gbwa = driver.findElement(By.xpath("//input[@name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void combinedWithParentXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.cssSelector("div.a4bIc input[name='q']"));
        WebElement gbwa = driver.findElement(By.xpath("//div[@class='a4bIc']//input[@name='q']"));
        gbwa.sendKeys("java");
        SleepUtil.sleep(1500);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getAttribute("value"), "java");
    }

    @Test
    public void textXpathSelectorTest() {
        SleepUtil.sleep(1000);
        // WebElement gbwa = driver.findElement(By.linkText("Почта"));
        WebElement gbwa = driver.findElement(By.xpath("//*[text()='Почта']"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getText(), "Почта");
    }

    @Test
    public void partialTextXpathSelectorTest() {
        SleepUtil.sleep(1000);
        WebElement gbwa = driver.findElement(By.xpath("//*[contains(text(), 'Карт')]"));
        SleepUtil.sleep(1000);
        assertTrue(gbwa.isDisplayed());
        assertEquals(gbwa.getText(), "Картинки");
    }

    @Test
    public void indexXpathSelectorTest() {
        driver.navigate().to("https://www.google.com/");
        SleepUtil.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//center/input[3]"));
        System.out.println("seleniumFindElementSuccessMultipleElementTest -> " + element.getAttribute("aria-label"));
        System.out.println();
    }
}
