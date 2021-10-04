package ru.levelup.at.selenide;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.name;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelenideScriptTest {

    private static final Faker FAKER = new Faker();

    @BeforeMethod
    public void setUp() {
        Configuration.timeout = 9000;
        Configuration.baseUrl = "http://users.bugred.ru/";
        Configuration.startMaximized = true;
        // Configuration.headless = true;
        Selenide.open("");
    }

    @Test
    public void selenideExampleTest() {
        String username = FAKER.name().name();
        Selenide.$x("//a/span[text()='Войти']").click();

        Selenide.$x("//input[@name='name']").sendKeys(username);
        Selenide.$x("//input[@name='email']").sendKeys(FAKER.internet().emailAddress());
        Selenide.$x("//form[contains(@action, 'register')]//input[@name='password']")
                .sendKeys(FAKER.internet().password());
        Selenide.$(name("act_register_now")).click();

        String actualUsername = Selenide.$("#fat-menu > a[data-toggle='dropdown']")
                                        .shouldBe(Condition.visible).getText();

        assertThat(actualUsername)
            .as("User was not registered properly")
            .isEqualToIgnoringCase(username);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
