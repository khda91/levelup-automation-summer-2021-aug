package ru.levelup.at.allure;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.levelup.at.allure.listener.AllureSampleListener;
import ru.levelup.at.allure.steps.ActionStep;
import ru.levelup.at.allure.steps.AssertionStep;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;

@Feature("iiiiii")
@Epic("Регистрационный флоу")
@Story("Регистрация пользователя")
@Listeners(AllureSampleListener.class)
public class UserBugRedAllureTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();

    @Test(description = "Тест по регистрации пользователя")
    @Description("Проверка возможности регистрации пользователя на ресурсе через WEB UI")
    public void registerUserTest() {
        String username = FAKER.name().username();

        ActionStep actionStep = new ActionStep(driver);
        AssertionStep assertionStep = new AssertionStep(driver);

        actionStep.openHomePage();
        actionStep.registerUser(username, FAKER.internet().emailAddress(), FAKER.internet().password());
        assertionStep.usernameShouldBeDisplayedAndEqualTo(username);
    }

    @Test(description = "Тест по регистрации пользователя (падающий)")
    @Description("Проверка возможности регистрации пользователя на ресурсе через WEB UI")
    public void failedRegisterUserTest() {
        String username = FAKER.name().username();

        ActionStep actionStep = new ActionStep(driver);
        AssertionStep assertionStep = new AssertionStep(driver);

        actionStep.openHomePage();
        actionStep.registerUser(username, FAKER.internet().emailAddress(), FAKER.internet().password());
        assertionStep.usernameShouldBeDisplayedAndEqualTo(FAKER.name().fullName());
    }

    @Test(description = "Тест по регистрации пользователя (падающий ещё один)")
    @Description("Проверка возможности регистрации пользователя на ресурсе через WEB UI")
    public void oneMoreFailedRegisterUserTest() {
        String username = FAKER.name().username();

        ActionStep actionStep = new ActionStep(driver);
        AssertionStep assertionStep = new AssertionStep(driver);

        actionStep.openHomePage();
        actionStep.registerUser(username, FAKER.internet().emailAddress(), FAKER.internet().password());
        assertionStep.usernameShouldBeDisplayedAndEqualTo(FAKER.name().fullName());
    }
}
