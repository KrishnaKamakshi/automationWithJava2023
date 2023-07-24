package stepDefinations;

import EcommerceAPIsPOJO.LoginResponse;
import ResourceConstants.APIConstant;
import RestReqWebsiteAPIs.LoginSuccessFul;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class apiStepDefiniations {
    RequestSpecification reqPOST;
    ResponseSpecification responsePOST;
    Response responsePOST2;
    @Given("Add Request Payload i.e; JSON Body")
    public void add_Request_Payload_i_e_JSON_Body() {
        // Write code here that turns the phrase above into concrete actions
        RequestSpecification reqresT = new RequestSpecBuilder().
                setBaseUri("https://reqres.in").build();
        LoginSuccessFul loginSuccess = new LoginSuccessFul();
        loginSuccess.setEmail("eve.holt@reqres.in");
        loginSuccess.setPassword("cityslicka");
        reqPOST = given().spec(reqresT).header("Content-Type", "application/json").body(loginSuccess);
         responsePOST = new ResponseSpecBuilder().expectStatusCode(200).build();

    }

    @When("user calls POST APIs with HTTPs request")
    public void user_calls_POST_APIs_with_HTTPs_request() {
        // Write code here that turns the phrase above into concrete actions
        responsePOST2 = reqPOST.when().
                post("/api/login").then().log().all().spec(responsePOST).extract().response();
    }

    @Then("Validate the status code")
    public void validate_the_status_code_as() {
        // Write code here that turns the phrase above into concrete actions
        int statusCode = responsePOST2.getStatusCode();
        assertEquals(200,statusCode);
    }

}
