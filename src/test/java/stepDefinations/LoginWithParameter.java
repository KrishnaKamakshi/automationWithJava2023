package stepDefinations;

import AllPOJODefinitions.LibraryAPIs.PayloadLibrary;
import UtilsInformation.APIUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LoginWithParameter extends APIUtils {
    RequestSpecification libaryInformation;
    ResponseSpecification libaryInformationResponse;
    Response bookResponse;

    @Given("Making the POST request by using user names through Examples with {string}  {string} {string} {string}")
    public void makingThePOSTRequestByUsingUserNamesThroughExamplesWith(String name, String isbn, String aisle, String author) throws IOException {
        PayloadLibrary payloadBooks = new PayloadLibrary();
        payloadBooks.setName(name);
        payloadBooks.setIsbn(isbn);
        payloadBooks.setAisle(aisle);
        payloadBooks.setAuthor(author);
        libaryInformation = given().
                spec(requestBuilder("libraryURL"))
                .header("Content-Type", "application/json")
                .body(payloadBooks);
        libaryInformationResponse = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    @When("user makes a POST call")
    public void user_makes_a_POST_call() {
        // Write code here that turns the phrase above into concrete actions
        bookResponse = libaryInformation.when().
                post("/Library/Addbook.php").then().spec(libaryInformationResponse).extract().response();
        System.out.println(bookResponse.getBody().asPrettyString());

    }

    @Then("Status code should be {int}")
    public void status_code_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        int statusCode = bookResponse.getStatusCode();
        assertEquals(200, statusCode);

    }

}
