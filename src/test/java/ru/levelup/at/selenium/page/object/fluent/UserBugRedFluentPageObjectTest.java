package ru.levelup.at.selenium.page.object.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;

public class UserBugRedFluentPageObjectTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();
    private static final String USERNAME = "user123123";
    private static final String POSITIVE_USER_EMAIL = "user123123@mail.ru";
    private static final String NEGATIVE_USER_EMAIL = "user123123@mail.com";
    private static final String PASSWORD = "12345678";

    @Test
    public void registerUserTest() {
        String username = FAKER.name().username();
        UserBugRedLoginRegistrationPage registrationPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton();

        UserBugRedIndexPage indexPage = registrationPage
            .sendKeysToRegisterNameInputField(username)
            .sendKeysToRegisterEmailInputField(FAKER.internet().emailAddress())
            .sendKeysToRegisterPasswordInputField(FAKER.internet().password())
            .clickRegisterButton();

        assertThat(indexPage.isIndicationBarDisplayed())
            .as(String.format("%s user was not registered", username))
            .isTrue();
        assertThat(indexPage.getUsername())
            .as("Incorrect user name was created in database")
            .isEqualTo(username);
    }

    @Test
    public void registerUserWithoutAdditionalPagesTest() {
        String username = FAKER.name().username();
        UserBugRedIndexPage indexPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton()
            .sendKeysToRegisterNameInputField(username)
            .sendKeysToRegisterEmailInputField(FAKER.internet().emailAddress())
            .sendKeysToRegisterPasswordInputField(FAKER.internet().password())
            .clickRegisterButton();

        assertThat(indexPage.isIndicationBarDisplayed())
            .as(String.format("%s user was not registered", username))
            .isTrue();
        assertThat(indexPage.getUsername())
            .as("Incorrect user name was created in database")
            .isEqualTo(username);
    }

    @Test
    public void positiveLoginTest() {
        UserBugRedLoginRegistrationPage loginPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton();

        UserBugRedIndexPage indexPage = loginPage
            .sendKeysToLoginEmailInputField(POSITIVE_USER_EMAIL)
            .sendKeysToLoginPasswordInputField(PASSWORD)
            .clickToAuthorizeButtonPositive();

        assertThat(indexPage.isIndicationBarDisplayed())
            .as(String.format("%s user was not authorized", USERNAME))
            .isTrue();
        assertThat(indexPage.getUsername())
            .as("Incorrect user name was displayed")
            .isEqualTo(USERNAME);
    }

    @Test
    public void negativeLoginTest() {
        UserBugRedLoginRegistrationPage loginPage = new UserBugRedIndexPage(driver)
            .open()
            .clickEnterButton();

        boolean authorizeButtonDisplayed = loginPage
            .sendKeysToLoginEmailInputField(NEGATIVE_USER_EMAIL)
            .sendKeysToLoginPasswordInputField(PASSWORD)
            .clickToAuthorizeButtonNegative()
            .isAuthorizeButtonDisplayed();

        assertThat(authorizeButtonDisplayed)
            .as(String.format("%s user was authorized", USERNAME))
            .isTrue();
    }
}
