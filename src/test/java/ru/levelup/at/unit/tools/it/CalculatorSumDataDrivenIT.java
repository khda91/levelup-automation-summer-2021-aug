package ru.levelup.at.unit.tools.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorSumDataDrivenIT extends AbstractBaseCalculatorIT {

    //    @DataProvider
    //    public Object[][] sumPositiveDataProvider() {
    //        return new Object[][] {
    //            {2, 2, 4},
    //            {5, 5, 10},
    //            {3, 4, 7},
    //            {6, 8, 14}
    //        };
    //    }

    @ParameterizedTest
    @CsvSource({
        "2,2,4",
        "5,5,10",
        "3,4,7",
        "6,8,14"})
    public void sumTest(int a, int b, int expectedSum) {
        System.out.println("sumTest");
        int actualSum = calculator.sum(a, b);
        Assertions.assertEquals(actualSum, expectedSum, "Incorrect result");
    }

    //    @DataProvider(name = "Sum Negative Data Provider")
    //    public Object[][] sumNegativeDataProvider() {
    //        return new Object[][] {
    //            {2, 2, 5},
    //            {5, 5, 11},
    //            {3, 4, 6}
    //        };
    //    }

    //    @Test(dataProvider = "Sum Negative Data Provider")
    @ParameterizedTest
    @CsvSource({
        "2,2,5",
        "5,5,5",
        "3,4,5",
        "6,8,5"})
    public void sumNegativeTest(int a, int b, int expectedSum) {
        System.out.println("sumNegativeTest");
        int actualSum = calculator.sum(a, b);
        Assertions.assertNotEquals(actualSum, expectedSum, "Incorrect result");
    }
}
