package ru.levelup.at.unit.tools;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorSampleTest {

    private Calculator calculator;

    @BeforeClass
    public void beforeTestClass() {
        System.out.println("beforeTestClass");
    }

    @BeforeMethod
    public void beforeTestMethod() {
        System.out.println("beforeTestMethod");
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        System.out.println("sumTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 2;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        int actualSum = calculator.subtract(3, 2);
        int expectedSum = 3 - 2;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
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
