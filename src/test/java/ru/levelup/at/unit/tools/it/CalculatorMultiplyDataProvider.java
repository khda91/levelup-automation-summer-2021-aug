package ru.levelup.at.unit.tools.it;

import org.testng.annotations.DataProvider;

public class CalculatorMultiplyDataProvider {

    @DataProvider
    public Object[][] multiplyPositiveDataProvider() {
        return new Object[][] {
            {2, 2, 4},
            {3, 3, 9},
            {8, 8, 64}
        };
    }

    @DataProvider(name = "Multiply Negative Data Provider")
    public Object[][] multiplyNegativeDataProvider() {
        return new Object[][] {
            {2, 2, 5},
            {3, 3, 1},
            {8, 8, 1},
            {9, 9, 0}
        };
    }
}
