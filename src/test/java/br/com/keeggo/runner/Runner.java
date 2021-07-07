package br.com.keeggo.runner;

import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/resources/features/",
			glue = "br.com.keeggo.steps",
			monochrome = true,
			snippets = SnippetType.CAMELCASE,
			plugin = {"pretty", "html:target/reportRelatorio/report.html", 
					"com.cucumber.listener.ExtentCucumberFormatter:target/reportRelatorio/reportSuiteDeTestes.html"},
			dryRun = false
		)
public class Runner {
	
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File("./extent-config.xml"));
	}
}
