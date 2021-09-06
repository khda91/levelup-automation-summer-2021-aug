package ru.levelup.at.unit.tools.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AbstractBaseCalculatorTest {

    @Test
    public void sumTest() {
        System.out.println("sumTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 2;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @Test
    public void sumNegativeTest() {
        System.out.println("sumNegativeTest");
        int actualSum = calculator.sum(2, 2);
        int expectedSum = 2 + 3;
        Assert.assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}
