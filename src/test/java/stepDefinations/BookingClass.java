package stepDefinations;

import AllPOJODefinitions.RestFUL.AuthBody;
import AllPOJODefinitions.RestFUL.BookingCreation;
import AllPOJODefinitions.RestFUL.BookingDates;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import UtilsInformation.APIUtils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class BookingClass extends APIUtils {

    RequestSpecification reqRESTBooking;
    Response reponseRESTBooking;
    Response reponseREST2Booking;
    RequestSpecification reqAuthToken;
    Response getAuthTokenWithPOST;
    Response getStatusAfterDeletionofABookingID;
    String  getToken;
    int bookingID2;

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

        String getBookingID = reponseRESTBooking.getBody().asPrettyString();
        System.out.println(getBookingID);
        bookingID2 = Integer.parseInt(reponseRESTBooking.getBody().jsonPath().getString("bookingid"));
    }
    @Given("Bearer Token is generated with using auth API with {string} and {string} and it is passed as cookie value")
    public void bearer_Token_is_generated_with_using_auth_API_with_and_and_it_is_passed_as_cookie_value(String username, String password) throws IOException {
        AuthBody bodyCreation = new AuthBody();
        bodyCreation.setUsername(username);
        bodyCreation.setPassword(password);
        reqAuthToken = given().spec(requestBuilder("restfulURL")).header("Content-Type", "application/json")
                .body(bodyCreation).log().all();
    }
    @When("There is a bookingid created pass the above token as Cookie with the booking id as {int}")
    public void there_is_a_bookingid_created_pass_the_above_token_as_Cookie_with_the_booking_id_as(Integer bookingID2) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        getAuthTokenWithPOST = reqAuthToken.when().log().all().post("/auth").then().extract().response();
        getToken = getAuthTokenWithPOST.getBody().asPrettyString();
        JsonPath jsPath = new JsonPath(getToken);
        String tokenCreation   = jsPath.getString("token");
        RequestSpecification requestPath = given().spec(requestBuilder("restfulURL")).header("Content-Type", "application/json")
                .header("Cookie","token="+tokenCreation).log().all();
        PrintStream stream = new PrintStream(new FileOutputStream("src/test/resources/loggingFile/logRunTimeFileRestFul.log"));
        getStatusAfterDeletionofABookingID = requestPath.filter(RequestLoggingFilter.logRequestTo(stream)).when().log().all().delete("/booking/"+bookingID2).then().extract().response();
    }
    @Then("Delete the BookingID and validate the status code")
    public void delete_the_BookingID_and_validate_the_status_code() {
        // Write code here that turns the phrase above into concrete actions
        int statusCodeDeleted = getStatusAfterDeletionofABookingID.getStatusCode();
        assertEquals(201,statusCodeDeleted);
    }

}
