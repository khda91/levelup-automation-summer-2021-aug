package ru.levelup.at.design.patterns.singletone.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(name = "act_register_now")
    private WebElement registerButton;

    public void sendKeysToNameInputField(final String name) {
        sendKeysToElement(nameInputField, name);
    }

    public void sendKeysToEmailInputField(final String email) {
        sendKeysToElement(emailInputField, email);
    }

    public void sendKeysToPasswordInputField(final String password) {
        sendKeysToElement(passwordInputField, password);
    }

    public void clickRegisterButton() {
        clickOnElement(registerButton);
    }
}
