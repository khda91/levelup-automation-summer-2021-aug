package ru.levelup.at.selenium.page.object.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement registerNameInputField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement registerEmailInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement registerPasswordInputField;

    @FindBy(name = "act_register_now")
    private WebElement registerButton;

    @FindBy(name = "login")
    private WebElement loginEmailInputField;

    @FindBy(xpath = "//form[contains(@action, 'login')]//input[@name='password']")
    private WebElement loginPasswordInputField;

    @FindBy(xpath = "//input[@value='Авторизоваться']")
    private WebElement authorizeButton;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public UserBugRedLoginRegistrationPage sendKeysToRegisterNameInputField(final String name) {
        sendKeysToElement(registerNameInputField, name);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToRegisterEmailInputField(final String email) {
        sendKeysToElement(registerEmailInputField, email);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToRegisterPasswordInputField(final String password) {
        sendKeysToElement(registerPasswordInputField, password);
        return this;
    }

    public UserBugRedIndexPage clickRegisterButton() {
        clickOnElement(registerButton);
        return new UserBugRedIndexPage(driver);
    }

    public UserBugRedLoginRegistrationPage sendKeysToLoginEmailInputField(final String email) {
        sendKeysToElement(loginEmailInputField, email);
        return this;
    }

    public UserBugRedLoginRegistrationPage sendKeysToLoginPasswordInputField(final String password) {
        sendKeysToElement(loginPasswordInputField, password);
        return this;
    }

    public UserBugRedIndexPage clickToAuthorizeButtonPositive() {
        clickOnElement(authorizeButton);
        return new UserBugRedIndexPage(driver);
    }

    public UserBugRedLoginRegistrationPage clickToAuthorizeButtonNegative() {
        clickOnElement(authorizeButton);
        return this;
    }

    public boolean isAuthorizeButtonDisplayed() {
        return authorizeButton.isDisplayed();
    }
}
