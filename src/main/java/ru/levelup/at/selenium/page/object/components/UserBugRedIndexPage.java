package ru.levelup.at.selenium.page.object.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedIndexPage extends UserBugRedBasePage {

    private static final String URL = "http://users.bugred.ru/";

    @FindBy(css = "ul.pull-right")
    private WebElement indicationBar;

    @FindBy(css = "#fat-menu > a[data-toggle='dropdown']")
    private WebElement userMenu;

    public UserBugRedIndexPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.navigate().to(URL);
    }

    public boolean isIndicationBarDisplayed() {
        return indicationBar.isDisplayed();
    }

    public String getUsername() {
        return wait.until(visibilityOf(userMenu)).getText();
    }
}
