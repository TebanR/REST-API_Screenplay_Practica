package co.com.practice.question.reqres;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class TokenAndResponse implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).body().prettyPeek().asPrettyString();
    }

    public static TokenAndResponse tokenAndResponse() {
        return new TokenAndResponse();
    }
}
