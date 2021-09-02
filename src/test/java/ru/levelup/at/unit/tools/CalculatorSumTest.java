package ru.levelup.at.unit.tools;

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
}
