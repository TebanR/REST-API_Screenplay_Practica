package co.com.practice.stepdefinition.reqres.create;

import co.com.practice.stepdefinition.reqres.setup.InitialSetUp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.io.IOException;

import static co.com.practice.question.reqres.TokenAndResponse.tokenAndResponse;
import static co.com.practice.task.reqres.CreateUser.createUser;
import static co.com.practice.util.common.FileReader.getJsonFromFile;
import static co.com.practice.util.reqres.Constants.*;
import static co.com.practice.util.reqres.PostCreateKeys.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDenifitions extends InitialSetUp {
    @Before
    public void setUp() {
        generalSetUp();
    }

    @Given("that the user is in the service")
    public void thatTheUserIsInTheService() {
        theActorInTheSpotlight().can(CallAnApi.at(URL_BASE));
    }

    @When("the user registers with his credentials name {string} and job {string}")
    public void theUserRegistersWithHisCredentialsNameAndJob(String name, String job) throws IOException {
        theActorInTheSpotlight().attemptsTo(
                createUser().inResource(REQRES_CREATE_RESOURCE)
                        .withBodyRequest(getJsonFromFile(REQRES_CREATE_JSON)
                                .replace(NAME.getValue(), name)
                                .replace(JOB.getValue(), job)));
    }

    @Then("the user should see a success response code and build id")
    public void theUserShouldSeeASuccessResponseCodeAndBuildId() {
        theActorInTheSpotlight().should(seeThat(tokenAndResponse(), Matchers.containsString("id".trim())));
    }


}
