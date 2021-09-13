package ru.levelup.at.selenium;

import static org.testng.Assert.assertTrue;

import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumActionBuilderExampleTest extends SeleniumBaseTest {

    @Test
    public void actionBuilderTest() {
        driver.navigate().to("https://ozon.ru");
        driver.findElement(By.xpath("//div[text()='Каталог']")).click();
        driver.findElement(By.xpath("//div[@data-widget='catalogMenu']/div[2]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        var categoryLink = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.partialLinkText("Детские товары")));
        Actions actions = new Actions(driver)
            .moveToElement(categoryLink);
        actions.perform();
        new Actions(driver).click(wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.xpath("//span[text()='Коляски']")))).perform();
        // new Actions(driver)
        //     .moveToElement(categoryLink)
        //     .click(wait.until(ExpectedConditions
        //         .visibilityOfElementLocated(By.xpath("//span[text()='Коляски']"))))
        //     .build()
        //     .perform();
        assertTrue(driver.getTitle().toLowerCase(Locale.ROOT).contains("коляски"));
    }
}
