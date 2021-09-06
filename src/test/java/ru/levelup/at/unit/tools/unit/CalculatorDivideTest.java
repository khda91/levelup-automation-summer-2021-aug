package ru.levelup.at.unit.tools.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorDivideTest extends AbstractBaseCalculatorTest {

    @Test
    public void divideTest() {
        System.out.println("divideTest");
        int actualSum = calculator.divide(6, 2);
        int expectedSum = 6 / 2;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }
}
