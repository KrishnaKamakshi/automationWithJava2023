package apiLearnings.JIRA;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadFiles.Payload;

import static io.restassured.RestAssured.*;

public class LibraryAPIs {

    @Test(dataProvider = "qaBookData")
    public void testAddBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String responseOfAddBook = given().log().all().header("Content-Type", "application/json")
                .body(Payload.AddBookPayLoad(isbn, aisle)).when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsPath = new JsonPath(responseOfAddBook);
        System.out.println(jsPath.getString("ID"));

    }

    // Server ID: BT7M-8QZ5-P1TT-VBTY - JIRA
    @DataProvider(name = "qaBookData")
    public Object[][] getData() {
        return new Object[][]{{"QATest1", "TestQAAutomation"}, {"QATest2", "TestQAAutomation2"}};
    }

}
