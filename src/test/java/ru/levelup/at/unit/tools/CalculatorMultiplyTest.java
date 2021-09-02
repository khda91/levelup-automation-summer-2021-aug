package ru.levelup.at.unit.tools;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest extends AbstractBaseCalculatorTest {

    @Test
    public void multiplyTest() {
        System.out.println("multiplyTest");
        int actualSum = calculator.multiply(2, 9);
        int expectedSum = 2 * 9;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }
}
