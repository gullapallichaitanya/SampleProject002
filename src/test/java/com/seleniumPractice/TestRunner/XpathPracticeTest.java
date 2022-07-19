package com.seleniumPractice.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"features"},
		glue = {"com.seleniumPractice.Steps"},
		monochrome = true,
		plugin = {"pretty", "html:mavenreports/report.html"}

)

public class XpathPracticeTest {


}
