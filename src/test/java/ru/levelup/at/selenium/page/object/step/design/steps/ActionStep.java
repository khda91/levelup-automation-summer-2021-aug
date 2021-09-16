package ru.levelup.at.selenium.page.object.step.design.steps;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.step.design.UserBugRedIndexPage;
import ru.levelup.at.selenium.page.object.step.design.UserBugRedLoginRegistrationPage;

public class ActionStep {

    private WebDriver driver;

    public ActionStep(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        new UserBugRedIndexPage(driver).open();
    }

    public void registerUser(String username, String email, String password) {
        new UserBugRedIndexPage(driver).clickEnterButton();
        UserBugRedLoginRegistrationPage registrationPage = new UserBugRedLoginRegistrationPage(driver);
        registrationPage.sendKeysToNameInputField(username);
        registrationPage.sendKeysToEmailInputField(email);
        registrationPage.sendKeysToPasswordInputField(password);
        registrationPage.clickRegisterButton();
    }
}
