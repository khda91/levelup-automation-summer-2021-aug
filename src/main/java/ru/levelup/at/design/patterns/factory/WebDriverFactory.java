package ru.levelup.at.design.patterns.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String OPERA = "opera";
    private static final String FIREFOX = "firefox";

    private WebDriverFactory() {

    }

    public static WebDriver createDriver(final String browserName) {
        if (CHROME.equalsIgnoreCase(browserName)) {
            return createChromeDriver();
        } else if (OPERA.equalsIgnoreCase(browserName)) {
            return createOperaDriver();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            return createFirefoxDriver();
        } else {
            throw new IllegalArgumentException(String.format("%s is unsupported browser", browserName));
        }
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
