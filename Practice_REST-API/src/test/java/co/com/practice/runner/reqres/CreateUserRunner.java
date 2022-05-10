package co.com.practice.runner.reqres;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reqres/createUser.feature",
        glue = "co.com.practice.stepdefinition.reqres.create",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CreateUserRunner {
}
