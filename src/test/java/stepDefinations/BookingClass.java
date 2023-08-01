package stepDefinations;

import AllPOJODefinitions.RestFUL.BookingCreation;
import AllPOJODefinitions.RestFUL.BookingDates;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import AllPOJODefinitions.RestFUL.Restful;
import UtilsInformation.APIUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class BookingClass extends APIUtils {

    RequestSpecification reqRESTBooking;
    Response reponseRESTBooking;
    Response reponseREST2Booking;
    String bookingID;

    @Given("API got valid all validae details with {string}  {string} {string} {string} {string} {string}, {string}")
    public void apiGotValidAllValidaeDetailsWith(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) throws IOException {
        BookingDates bDates = new BookingDates();
        bDates.setCheckin(checkin);
        bDates.setCheckout(checkout);
        BookingCreation bookingBody = new BookingCreation();
        bookingBody.setFirstname(firstname);
        bookingBody.setLastname(lastname);
        bookingBody.setAdditionalneeds(additionalneeds);
        bookingBody.setBookingdates(bDates);
        bookingBody.setTotalprice(Integer.parseInt(totalprice));
        bookingBody.setDepositpaid(Boolean.parseBoolean(depositpaid));
        reqRESTBooking = given().spec(requestBuilder("restfulURL")).header("Content-Type", "application/json")
                .log().all().body(bookingBody);
    }

    @When("Validate if the end point is hit with valid returns as status code and id")
    public void validate_if_the_end_point_is_hit_with_valid_returns_as_status_code_and_id() {
        // Write code here that turns the phrase above into concrete actions
        reponseRESTBooking = reqRESTBooking.when().post("/booking").then().extract().response();
    }

    @Then("validate the response")
    public void validate_the_response() {
        // Write code here that turns the phrase above into concrete actions
        int statusCode = reponseRESTBooking.getStatusCode();
        assertEquals(200,statusCode);
    }
}
