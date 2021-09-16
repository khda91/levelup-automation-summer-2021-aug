package ru.levelup.at.selenium.page.object.components.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderButtonsComponent extends BaseComponent {

    @FindBy(xpath = "//a/span[text()='Войти']")
    private WebElement enterButton;

    public HeaderButtonsComponent(WebDriver driver) {
        super(driver);
    }

    public void clickEnterButton() {
        clickOnElement(enterButton);
    }
}
