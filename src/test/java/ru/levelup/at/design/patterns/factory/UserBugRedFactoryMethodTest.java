package ru.levelup.at.design.patterns.factory;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelup.at.design.patterns.factory.voids.UserBugRedIndexPage;
import ru.levelup.at.design.patterns.factory.voids.UserBugRedLoginRegistrationPage;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;

public class UserBugRedFactoryMethodTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();

    @BeforeSuite
    @Override
    public void setUpSuite() {
        // System.setProperty("browser.name", "opera");
    }

    @BeforeMethod
    @Override
    public void setUp(ITestContext context) {
        WebDriverSingleton.getDriver();
    }

    @AfterMethod
    @Override
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }

    @Test
    public void registerUserTest() {
        String username = FAKER.name().username();
        UserBugRedIndexPage indexPage = new UserBugRedIndexPage();

        indexPage.open();
        indexPage.clickEnterButton();

        UserBugRedLoginRegistrationPage registrationPage = new UserBugRedLoginRegistrationPage();
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
