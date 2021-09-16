package ru.levelup.at.selenium.page.object.step.design.steps;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.step.design.UserBugRedIndexPage;

public class AssertionStep {

    private WebDriver driver;

    public AssertionStep(WebDriver driver) {
        this.driver = driver;
    }

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
