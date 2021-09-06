package ru.levelup.at.unit.tools.unit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelup.at.unit.tools.Calculator;

public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeTestSuite() {
        System.out.println("beforeTestSuite");
    }

    @BeforeTest
    public void beforeTestTest() {
        System.out.println("beforeTestTest");
    }

    @BeforeClass
    public void beforeTestClass() {
        System.out.println("beforeTestClass");
    }

    @BeforeMethod
    public void beforeTestMethod() {
        System.out.println("beforeTestMethod");
        calculator = new Calculator();
    }

    @AfterMethod
    public void afterTestMethod() {
        System.out.println("afterTestMethod");
        calculator = null;
    }

    @AfterClass
    public void afterTestClass() {
        System.out.println("afterTestClass");
    }

    @AfterTest
    public void afterTestTest() {
        System.out.println("afterTestTest");
    }

    @AfterSuite
    public void afterTestSuite() {
        System.out.println("afterTestSuite");
    }
}
