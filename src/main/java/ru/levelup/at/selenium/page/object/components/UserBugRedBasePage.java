package ru.levelup.at.selenium.page.object.components;

import org.openqa.selenium.WebDriver;
import ru.levelup.at.selenium.page.object.components.element.BaseComponent;
import ru.levelup.at.selenium.page.object.components.element.HeaderButtonsComponent;

public abstract class UserBugRedBasePage extends BaseComponent {

    private HeaderButtonsComponent headerButtonsComponent;

    protected UserBugRedBasePage(WebDriver driver) {
        super(driver);
        headerButtonsComponent = new HeaderButtonsComponent(driver);
    }

    public HeaderButtonsComponent getHeaderButtonsComponent() {
        return headerButtonsComponent;
    }

    public void clickEnterButton() {
        headerButtonsComponent.clickEnterButton();
    }
}
