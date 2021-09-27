package ru.levelup.at.selenium.page.object.script;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.selenium.page.object.BaseSeleniumPageObjectTest;

public class UserBugRedScriptingTest extends BaseSeleniumPageObjectTest {

    private static final Faker FAKER = new Faker();

    private WebDriverWait wait;

    @BeforeMethod
    @Override
    public void setUp(ITestContext context) {
        super.setUp(context);
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to("http://users.bugred.ru/");
    }

    @Test
    public void registerUserTest() {
        String username = FAKER.name().name();
        wait.until(elementToBeClickable(xpath("//a/span[text()='Войти']"))).click();

        wait.until(visibilityOfElementLocated(xpath("//input[@name='name']")))
            .sendKeys(username);
        wait.until(visibilityOfElementLocated(xpath("//input[@name='email']")))
            .sendKeys(FAKER.internet().emailAddress());
        wait.until(visibilityOfElementLocated(xpath("//form[contains(@action, 'register')]//input[@name='password']")))
            .sendKeys(FAKER.internet().password());
        wait.until(elementToBeClickable(name("act_register_now"))).click();

        String actualUsername =
            wait.until(visibilityOfElementLocated(cssSelector("#fat-menu > a[data-toggle='dropdown']"))).getText();

        assertThat(actualUsername)
            .as("User was not registered properly")
            .isEqualToIgnoringCase(username);
    }
}
