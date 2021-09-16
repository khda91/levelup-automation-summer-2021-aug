package ru.levelup.at.selenium.page.object.components;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;

public class UserBugRedPageObjectComponentsTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void registerUserTest() {
        String username = FAKER.name().username();
        UserBugRedIndexPage indexPage = new UserBugRedIndexPage(driver);

        indexPage.open();
        indexPage.clickEnterButton();

        UserBugRedLoginRegistrationPage registrationPage = new UserBugRedLoginRegistrationPage(driver);
        registrationPage.sendKeysToNameInputField(username);
        registrationPage.sendKeysToEmailInputField(FAKER.internet().emailAddress());
        registrationPage.sendKeysToPasswordInputField(FAKER.internet().password());
        registrationPage.clickRegisterButton();

        assertThat(indexPage.isIndicationBarDisplayed())
            .as(String.format("%s user was not registered", username))
            .isTrue();
        assertThat(indexPage.getUsername())
            .as("Incorrect user name was created in database")
            .isEqualTo(username);
    }
}
