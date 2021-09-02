package ru.levelup.at.unit.tools;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseCalculatorTest {

    protected Calculator calculator;

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
}
