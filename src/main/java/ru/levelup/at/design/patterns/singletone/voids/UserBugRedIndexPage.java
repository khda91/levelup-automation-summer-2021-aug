package ru.levelup.at.design.patterns.singletone.voids;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levelup.at.design.patterns.singletone.WebDriverSingleton;

public class UserBugRedIndexPage extends UserBugRedBasePage {

    private static final String URL = "http://users.bugred.ru/";

    @FindBy(xpath = "//a/span[text()='Войти']")
    private WebElement enterButton;

    @FindBy(css = "ul.pull-right")
    private WebElement indicationBar;

    @FindBy(css = "#fat-menu > a[data-toggle='dropdown']")
    private WebElement userMenu;

    public void open() {
        WebDriverSingleton.getDriver().navigate().to(URL);
    }

    public void clickEnterButton() {
        clickOnElement(enterButton);
    }

    public boolean isIndicationBarDisplayed() {
        return indicationBar.isDisplayed();
    }

    public String getUsername() {
        return wait.until(visibilityOf(userMenu)).getText();
    }
}
