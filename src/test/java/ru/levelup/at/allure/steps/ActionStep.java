package ru.levelup.at.allure.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelup.at.allure.UserBugRedIndexPage;
import ru.levelup.at.allure.UserBugRedLoginRegistrationPage;

public class ActionStep {

    private WebDriver driver;

    public ActionStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть домашнюю страницу приложения")
    public void openHomePage() {
        new UserBugRedIndexPage(driver).open();
    }

    @Step("Регистрируем пользователя")
    public void registerUser(String username, String email, String password) {
        new UserBugRedIndexPage(driver).clickEnterButton();
        UserBugRedLoginRegistrationPage registrationPage = new UserBugRedLoginRegistrationPage(driver);
        registrationPage.sendKeysToNameInputField(username);
        registrationPage.sendKeysToEmailInputField(email);
        registrationPage.sendKeysToPasswordInputField(password);
        registrationPage.clickRegisterButton();
    }
}
