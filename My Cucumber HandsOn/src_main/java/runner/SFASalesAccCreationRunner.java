package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/main/java/features/SFASalesAccCreation.feature" , glue="steps", monochrome=true, publish = true)
public class SFASalesAccCreationRunner extends AbstractTestNGCucumberTests{

}