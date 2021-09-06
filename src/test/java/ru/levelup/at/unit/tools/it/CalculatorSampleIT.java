package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelup.at.unit.tools.Calculator;

public class CalculatorSampleIT {

    private Calculator calculator;

    @BeforeAll
    public static void beforeTestClass() {
        System.out.println("beforeTestClass");
    }

    @BeforeEach
    public void beforeTestMethod() {
        System.out.println("beforeTestMethod");
        calculator = new Calculator();
    }

    @Test
    public void sumTest() {
        System.out.println("sumTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 2;
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        int actualSum = calculator.subtract(3, 2);
        int expectedSum = 3 - 2;
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @AfterEach
    public void afterTestMethod() {
        System.out.println("afterTestMethod");
        calculator = null;
    }

    @AfterAll
    public static void afterTestClass() {
        System.out.println("afterTestClass");
    }
}
