package ru.levelup.at.unit.tools.unit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumDataDrivenTest extends AbstractBaseCalculatorTest {

    @DataProvider
    public Object[][] sumPositiveDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {5, 5, 10},
            {3, 4, 7},
            {6, 8, 14}
        };
    }

    @Test(dataProvider = "sumPositiveDataProvider")
    public void sumTest(int a, int b, int expectedSum) {
        System.out.println("sumTest");
        int actualSum = calculator.sum(a, b);
        Assert.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    @DataProvider(name = "Sum Negative Data Provider")
    public Object[][] sumNegativeDataProvider() {
        return new Object[][] {
            {2, 2, 5},
            {5, 5, 11},
            {3, 4, 6}
        };
    }

    @Test(dataProvider = "Sum Negative Data Provider")
    public void sumNegativeTest(int a, int b, int expectedSum) {
        System.out.println("sumNegativeTest");
        int actualSum = calculator.sum(a, b);
        Assert.assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}
