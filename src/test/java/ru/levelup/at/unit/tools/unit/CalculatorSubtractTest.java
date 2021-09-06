package ru.levelup.at.unit.tools.unit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorSubtractTest extends AbstractBaseCalculatorTest {

    @Test
    public void subtractTest() {
        System.out.println("subtractTest");
        int actualSum = calculator.subtract(3, 2);
        int expectedSum = 3 - 2;
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }
}
