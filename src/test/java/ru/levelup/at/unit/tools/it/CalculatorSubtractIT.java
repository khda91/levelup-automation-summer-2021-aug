package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorSubtractIT extends AbstractBaseCalculatorIT {

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        int actualSum = calculator.subtract(3, 2);
        int expectedSum = 3 - 2;
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }
}
