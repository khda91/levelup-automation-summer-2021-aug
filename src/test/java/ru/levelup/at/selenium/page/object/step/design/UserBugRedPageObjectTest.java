package ru.levelup.at.selenium.page.object.step.design;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;
import ru.levelup.at.selenium.page.object.step.design.steps.ActionStep;
import ru.levelup.at.selenium.page.object.step.design.steps.AssertionStep;

public class UserBugRedPageObjectTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();

    @Test
    public void registerUserTest() {
        String username = FAKER.name().username();

        ActionStep actionStep = new ActionStep(driver);
        AssertionStep assertionStep = new AssertionStep(driver);

        actionStep.openHomePage();
        actionStep.registerUser(username, FAKER.internet().emailAddress(), FAKER.internet().password());
        assertionStep.usernameShouldBeDisplayedAndEqualTo(username);
    }
}
