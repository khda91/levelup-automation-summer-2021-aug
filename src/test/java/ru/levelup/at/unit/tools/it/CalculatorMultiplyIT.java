package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorMultiplyIT extends AbstractBaseCalculatorIT {

    @Test
    public void multiplyTest() {
        System.out.println("multiplyTest");
        int actualSum = calculator.multiply(2, 9);
        int expectedSum = 2 * 9;
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }
}
