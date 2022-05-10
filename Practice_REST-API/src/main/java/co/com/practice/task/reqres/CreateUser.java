package co.com.practice.task.reqres;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static io.restassured.http.ContentType.JSON;

public class CreateUser implements Task {
    private String resource;
    private String bodyRequest;

    public CreateUser inResource(String resource) {
        this.resource = resource;
        return this;
    }

    public CreateUser withBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(JSON)
                                .body(bodyRequest)
                                .log().body())
        );

    }

    public static CreateUser createUser() {
        return new CreateUser();
    }
}
