package ru.levelup.at.selenium.page.object.fluent;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UserBugRedBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected UserBugRedBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected void clickOnElement(final WebElement element) {
        wait.until(elementToBeClickable(element)).click();
    }

    protected void sendKeysToElement(final WebElement element, final String text) {
        wait.until(visibilityOf(element)).sendKeys(text);
    }
}
