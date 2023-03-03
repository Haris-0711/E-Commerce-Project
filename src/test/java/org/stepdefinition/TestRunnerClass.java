package org.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions
	(features = "featurefiles" , 
	glue = "org.stepdefinition" ,
	monochrome = true ,
	dryRun = false,
	strict = false,
	snippets = SnippetType.CAMELCASE,
	
	plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:Reports","junit:Reports\\junitreport.xml","json:Reports\\jsonreport.json"}) 

	

	public class TestRunnerClass {
		

	}
