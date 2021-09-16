package ru.levelup.at.selenium.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumTakeScreenshotTest extends SeleniumBaseTest {

    @Test
    public void seleniumGoogleSearchHelpTakeScreenshotTest() throws IOException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("book");

        WebElement dropdownPossibleSearchResultsList;
        try {
            dropdownPossibleSearchResultsList = driver.findElement(By.cssSelector("ul[role='listbox1']"));
        } catch (NoSuchElementException e) {
            TakesScreenshot sc = (TakesScreenshot) driver;
            File screensFile = sc.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screensFile, new File("target/screen1.png"));
        }
    }
}
