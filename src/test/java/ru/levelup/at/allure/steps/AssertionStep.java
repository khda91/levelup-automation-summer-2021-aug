package ru.levelup.at.allure.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelup.at.allure.UserBugRedIndexPage;

public class AssertionStep {

    private WebDriver driver;

    public AssertionStep(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Имя пользователя должно совпадать с именем {expectedUsername}")
    public void usernameShouldBeDisplayedAndEqualTo(final String expectedUsername) {
        UserBugRedIndexPage indexPage = new UserBugRedIndexPage(driver);
        assertThat(indexPage.isIndicationBarDisplayed())
            .as(String.format("%s user was not registered", expectedUsername))
            .isTrue();
        assertThat(indexPage.getUsername())
            .as("Incorrect user name was created in database")
            .isEqualTo(expectedUsername);
    }
}
