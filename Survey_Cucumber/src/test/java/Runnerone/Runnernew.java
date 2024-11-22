package Runnerone;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(

			    features = "src/test/resources/featureone/Login.feature",  // Ensure this path is correct
			    dryRun = false,
			    glue = { "steps"},
			    snippets = SnippetType.CAMELCASE,
			    monochrome = true,
			    plugin = {"pretty", "html:Report/cucumber/report.html", "json:Report/cucumber/report.json"},
			    tags = "@Login"
			)
public class Runnernew extends AbstractTestNGCucumberTests {

}


 