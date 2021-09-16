package ru.levelup.at.selenium.page.object.fluent;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedIndexPage extends UserBugRedBasePage {

    private static final String URL = "http://users.bugred.ru/";

    @FindBy(xpath = "//a/span[text()='Войти']")
    private WebElement enterButton;

    @FindBy(css = "ul.pull-right")
    private WebElement indicationBar;

    @FindBy(css = "#fat-menu > a[data-toggle='dropdown']")
    private WebElement userMenu;

    public UserBugRedIndexPage(WebDriver driver) {
        super(driver);
    }

    public UserBugRedIndexPage open() {
        driver.navigate().to(URL);
        return this;
    }

    public UserBugRedLoginRegistrationPage clickEnterButton() {
        clickOnElement(enterButton);
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public boolean isIndicationBarDisplayed() {
        return indicationBar.isDisplayed();
    }

    public String getUsername() {
        return wait.until(visibilityOf(userMenu)).getText();
    }
}
