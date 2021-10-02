package runners;

import org.junit.runner.RunWith;

import br.com.bb.ath.ftabb.runner.FTABBCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(FTABBCucumberRunner.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report", "json:target/cucumber-report/cucumber.json", "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"},
            features = "classpath:features",
			glue = {"steps"},
			snippets = SnippetType.CAMELCASE, 
			monochrome = true, 
			strict = true, 
			tags = {"@chat_norminha"}, 
			dryRun = false)
public class RunnerTest {

}
