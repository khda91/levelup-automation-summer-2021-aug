package ru.levelup.at.unit.tools.it;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMultiplyDataDrivenIT extends AbstractBaseCalculatorIT {

    @Test(dataProviderClass = CalculatorMultiplyDataProvider.class,
          dataProvider = "multiplyPositiveDataProvider")
    public void multiplyTest(int a, int b, int expectedSum) {
        System.out.println("multiplyTest");
        int actualSum = calculator.multiply(a, b);
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @Test(dataProvider = "Multiply Negative Data Provider",
          dataProviderClass = CalculatorMultiplyDataProvider.class)
    public void multiplyNegativeTest(int a, int b, int expectedSum) {
        System.out.println("multiplyNegativeTest");
        int actualSum = calculator.multiply(a, b);
        Assert.assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}
