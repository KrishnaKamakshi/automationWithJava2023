package apiLearnings.JIRA;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadFiles.Payload;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class testAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// given, when, then

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String responseDemo = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.addPlaces()).when()
				.post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).extract().response().asPrettyString();

		System.out.println(responseDemo);

		JsonPath jsPath = new JsonPath(responseDemo);
		System.out.println(jsPath.getString("reference"));
		Assert.assertEquals(jsPath.getString("scope"), "APP");

		JsonPath jsPath2 = new JsonPath(Payload.CoursePrice());
		System.out.println(jsPath2.getString("dashboard.purchaseAmount"));
		// Assert.assertEquals(jsPath2.getString("scope"), "APP");

		// Get All titles
		int c = jsPath2.getInt("courses.size()");
		for (int i = 0; i < c; i++) {
				String courseNames = jsPath2.get("courses["+i+"].title");
				System.out.println(courseNames);
			int getNumberOfCopies = jsPath2.get("courses["+i+"].copies");
			System.out.println(getNumberOfCopies);
		}
	}

}
