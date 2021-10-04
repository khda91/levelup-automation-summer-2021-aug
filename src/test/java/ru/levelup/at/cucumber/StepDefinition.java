package ru.levelup.at.cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.name;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    private static final Faker FAKER = new Faker();
    private String username;
    private String actualUsername;

    @Given("I open User Bug Red Main page")
    public void openUserBugRedMainPage() {
        Selenide.open("http://users.bugred.ru/");
    }

    @When("I click 'Войти' button on the Main page")
    public void clickEnterButtonOnThMainPage() {
        Selenide.$x("//a/span[text()='Войти']").click();
    }

    @When("I fill 'Имя' field on the Main page")
    public void fillNameField() {
        username = FAKER.name().fullName();
        Selenide.$x("//input[@name='name']").sendKeys(username);
    }

    @When("I fill 'Email' field on the Main page")
    public void fillEmailField() {
        Selenide.$x("//input[@name='email']").sendKeys(FAKER.internet().emailAddress());
    }

    @When("I fill 'Password' field on the Main page")
    public void fillPasswordField() {
        Selenide.$x("//form[contains(@action, 'register')]//input[@name='password']")
                .sendKeys(FAKER.internet().password());
    }

    @Given("I click 'Зарегистрироваться' button on the Main page")
    public void clickRegistrationButton() {
        Selenide.$(name("act_register_now")).click();
    }

    @Then("user name dropdown should be visible")
    public void usernameDropdownShouldBeVisible() {
        actualUsername = Selenide.$("#fat-menu > a[data-toggle='dropdown']")
                                        .shouldBe(Condition.visible).getText();
    }

    @Then("user name should be equal entered user name")
    public void usernameShouldBeEqual() {
        assertThat(actualUsername)
            .as("User was not registered properly")
            .isEqualToIgnoringCase(username);
    }
}
