package ru.levelup.at.design.patterns.factory.voids;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelup.at.design.patterns.factory.WebDriverSingleton;

public abstract class UserBugRedBasePage {

    protected WebDriverWait wait;

    protected UserBugRedBasePage() {
        wait = new WebDriverWait(WebDriverSingleton.getDriver(), 10);
        PageFactory.initElements(WebDriverSingleton.getDriver(), this);
    }

    protected void clickOnElement(final WebElement element) {
        wait.until(elementToBeClickable(element)).click();
    }

    protected void sendKeysToElement(final WebElement element, final String text) {
        wait.until(visibilityOf(element)).sendKeys(text);
    }
}
