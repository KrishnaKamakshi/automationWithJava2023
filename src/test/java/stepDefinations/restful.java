package stepDefinations;

import AllPOJODefinitions.RestFUL.Restful;
import UtilsInformation.APIUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class restful extends APIUtils {
    RequestSpecification reqREST;
    Response reponseREST;
    Response reponseREST2;

    @Given("API got valid username and password")
    public void api_got_valid_username_and_password() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        Restful restPOST = new Restful();
        restPOST.setUsername("admin");
        restPOST.setPassword("password123");
        reqREST = given().spec(requestBuilder("restfulURL"))
                .log().all().body(restPOST).header("Content-Type", "application/json");

    }

    @When("Validate if the end point is hit with valid username and password")
    public void validate_if_the_end_point_is_hit_with_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        reponseREST = reqREST.when().
                post("/auth").then().extract().response();
        System.out.println(reponseREST.getBody().asPrettyString());
    }

    @Then("Token should be generated and response should be shown")
    public void token_should_be_generated_and_response_should_be_shown() {
        // Write code here that turns the phrase above into concrete actions throw new cucumber.api.PendingException();
        int statusCode = reponseREST.getStatusCode();
        assertEquals(200, statusCode);
    }

}
