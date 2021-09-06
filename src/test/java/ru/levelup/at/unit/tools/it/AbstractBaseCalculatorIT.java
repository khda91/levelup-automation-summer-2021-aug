package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.levelup.at.unit.tools.Calculator;

public abstract class AbstractBaseCalculatorIT {

    protected Calculator calculator;

    @BeforeAll
    public static void beforeTestClass() {
        System.out.println("beforeTestClass");
    }

    @BeforeEach
    public void beforeTestMethod() {
        System.out.println("beforeTestMethod");
        calculator = new Calculator();
    }

    @AfterEach
    public void afterTestMethod() {
        System.out.println("afterTestMethod");
        calculator = null;
    }

    @BeforeAll
    public static void afterTestClass() {
        System.out.println("afterTestClass");
    }
}
