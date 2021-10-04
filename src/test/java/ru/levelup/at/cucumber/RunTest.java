package ru.levelup.at.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:cucumber/features",
                 plugin = "pretty")
public class RunTest extends AbstractTestNGCucumberTests {
}
