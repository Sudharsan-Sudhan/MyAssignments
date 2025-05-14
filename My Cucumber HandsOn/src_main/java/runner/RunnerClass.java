package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/main/java/features/DeleteAccount.feature" , glue={"steps", "hooks"}, monochrome=true, publish = true)	
public class RunnerClass extends AbstractTestNGCucumberTests{

}
