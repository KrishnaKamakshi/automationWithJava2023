package MavenTesting.testQAAutomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    public String sessionCookie;
    public void testConnectionWithJIRA()
    {
        RestAssured.baseURI = "http://localhost:8083";
        SessionFilter session = new SessionFilter();
        String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json").body("""
                        {\r
                            "username": "krishnaqajira",\r
                            "password": "Werkspot1234$"\r
                        }""").log().all().when().post("/rest/auth/1/session").then().log().all().extract()
                .response().asPrettyString();
        JsonPath jsPath = new JsonPath(response);
        sessionCookie = jsPath.getString("session.value");

    }

    public String getSesstionCookieFromJIRA()
    {
        return sessionCookie;
    }
}
