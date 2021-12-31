package co.com.sofka.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/get_delete.feature"},
        glue = {"co.com.sofka.stepdefinition"},
        publish = true,
        tags = ""

)
public class PracticeFormTestCucumber {
}
