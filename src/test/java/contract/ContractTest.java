package contract;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.brainacad.RequestSpec.REQUEST_SPEC_REGRES_IN;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasKey;


public class ContractTest {

    @Test
    public void checkGetResponseStatusCode() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .param("page", 2)
                .when()
                .get()
                .then()
                //.body(matchesJsonSchemaInClasspath("usersResponseSchema.json"))
                .statusCode(200)
                .log().status()
                .log().body();
    }
    @Test//GET метод
    public void checkGetResponseBodyNotNull() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .basePath("api/users/23")
                .when()
                .get()
                .then()
                .body("isEmpty()", Matchers.is(true))
                .statusCode(404)
                .log().status();
    }

    @Test//POST метод
    public void checkPostResponseStatusCode() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("{\"name\": \"QA_Post\",\"job\": \"Auto\"}")
                .when()
                .post()
                .then()
               // .body(matchesJsonSchemaInClasspath("responseSchema.json"))
                .statusCode(201)
                .log().status()
                .log().body();
    }
    @Test//POST метод
    public void checkPostResponseBodyNotNull() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("")
                .when()
                .post()
                .then()
                .body("$", not(hasKey("name")))
                .and()
                .body("$", not(hasKey("job")))
                .log().body();
    }

    @Test//PUT метод
    public void checkPutResponseStatusCode() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("{\"name\": \"QA_PUT\",\"job\": \"Auto\"}")
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }
    @Test//PUT метод
    public void checkPutResponseBodyNotNull() {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("")
                .when()
                .put()
                .then()
                .body("$", not(hasKey("name")))
                .and()
                .body("$", not(hasKey("job")))
                .log().body();
    }

    @Test //PATCH метод
    public void checkPatchResponseStatusCode () {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("{\"name\": \"QA_PATCH\",\"job\": \"Auto\"}")
                .when()
                .patch()
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }
    @Test //PATCH метод
    public void checkPatchResponseBodyNotNull () {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .body("")
                .when()
                .patch()
                .then()
                .body("$", not(hasKey("name")))
                .and()
                .body("$", not(hasKey("job")))
                .log().body();
    }

    @Test //DELETE метод
    public void checkDeleteResponseStatusCode () {
        given()
                .spec(REQUEST_SPEC_REGRES_IN)
                .when()
                .delete()
                .then()
                .statusCode(204)
                .log().status()
                .log().body();
    }


}
