package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorDivideIT extends AbstractBaseCalculatorIT {

    @Test
    public void divideTest() {
        System.out.println("divideTest");
        int actualSum = calculator.divide(6, 2);
        int expectedSum = 6 / 2;
        Assertions.assertEquals(expectedSum, actualSum, "Incorrect result");
    }
}
