package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static com.brainacad.RequestSpec.REQUEST_SPEC_REGRES_IN;
import static io.restassured.RestAssured.given;

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

    @When("^ I Login as (User|Admin))$")
    public void test(){
        
    }
}