package ru.levelup.at.allure.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureSampleListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // attachScreenshot(BaseSeleniumPageObjectTest.driverStatic);
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("web_driver");
        attachScreenshotTestContext(result.getTestContext());
        // ((TakesScreenshot) result.getTestContext().getAttribute("web_driver")).getScreenshotAs()
        attachScreenshot(driver);
    }

    @Attachment(value = "Error_screenshot", fileExtension = ".png", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Error_screenshot12312", fileExtension = ".png", type = "image/png")
    public byte[] attachScreenshotTestContext(ITestContext context) {
        return ((TakesScreenshot) context.getAttribute("web_driver")).getScreenshotAs(OutputType.BYTES);
    }
}
