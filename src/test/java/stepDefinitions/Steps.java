package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static groovy.xml.Entity.not;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasKey;

public class Steps {

    private String url;
    private ValidatableResponse response;


    @Given("I have server by url {string}")
    public void i_have_server_by_url(String url) {
        // Write code here that turns the phrase above into concrete actions
        this.url = url;
        //throw new io.cucumber.java.PendingException();
    }

    @When("I send GET request on endpoint {string} with page {int}")
    public void i_send_GET_request_on_endpoint(String endpoint, int pageNumb) {
        // Write code here that turns the phrase above into concrete actions
        this.response = given()
                .baseUri(url)
                .basePath(endpoint)
                .contentType(ContentType.JSON)
                .param("page", pageNumb)
                .when()
                .get()
                .then();
        //throw new io.cucumber.java.PendingException();
    }

    @Then("I check if status code is {int}")
    public void i_check_if_status_code_equle(int code) {
        response.statusCode(code);
    }

    @When("I register new user with user name {string} and job {string}")
    public void register_new_user(String name, String job) {

        User user = User.builder()
                        .name(name)
                        .job(job)
                        .build();

        this.response = given()
                .baseUri(url)
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post()
                .then();
    }

   /* @When("^ I Login as (User|Admin))$")
    public void test(){
        
    }*/

    @Then("I get response with username {string} and job {string}")
    public void i_get_response_status_code_and_username_and_job(String name, String job) {
        response.body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    @When("I send an empty body")
    public void i_send_an_empty_body() {
        this.response = given()
                .baseUri(url)
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                //.body("{\"name\": \"QA_PUT\",\"job\": \"Auto\"}")
                .when()
                .post()
                .then();
    }

    @Then("I check if the response doesn't has name and job fields")
    public void i_check_if_the_response_doesnt_has_name_and_job_fields() {
        response.body("$", not(hasKey("name")));
        response.body("$", not(hasKey("job")));
    }
}
