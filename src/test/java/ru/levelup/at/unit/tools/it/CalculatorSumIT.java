package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorSumIT extends AbstractBaseCalculatorIT {

    @Test
    public void sumTest() {
        System.out.println("sumTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 2;
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @Test
    public void sumNegativeTest() {
        System.out.println("sumNegativeTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 3;
        Assertions.assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}
