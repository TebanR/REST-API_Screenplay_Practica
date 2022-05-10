package co.com.practice.stepdefinition.reqres.setup;

import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.log4j.PropertyConfigurator;

import static co.com.practice.util.log4j.Log4jValues.LOG4J_PROPERTIES_PATH;
import static co.com.practice.util.log4j.Log4jValues.USER_DIRECTORY;
import static co.com.practice.util.reqres.Constants.ACTOR_NAME;

public class InitialSetUp {
    private void setUpLog4J() {
        PropertyConfigurator.configure(USER_DIRECTORY.getValue() + LOG4J_PROPERTIES_PATH.getValue());
    }

    private void configureActor() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(ACTOR_NAME);
    }

    protected void generalSetUp() {
        setUpLog4J();
        configureActor();
    }
}
