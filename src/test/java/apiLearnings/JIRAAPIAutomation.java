package apiLearnings;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import payloadFiles.Payload;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JIRAAPIAutomation {
    String sessionCookie;
    int getJIRAID;

	/**
     * Login, Add a JIRA, Add a comment and Attachment - by using TestNG
     *
     * @return
     **/

    @BeforeTest
    public void testConnectionWithJIRA()
    {
        RestAssured.baseURI = "http://localhost:8083";
        SessionFilter session = new SessionFilter();
        String response = given().relaxedHTTPSValidation().header("Content-Type", "application/json").body("{\r\n" +
                        "    \"username\": \"krishnaqajira\",\r\n" +
                        "    \"password\": \"Werkspot1234$\"\r\n" +
                        "}").log().all().when().post("/rest/auth/1/session").then().log().all().extract()
                .response().asPrettyString();
        JsonPath jsPath = new JsonPath(response);
        sessionCookie = jsPath.getString("session.value");

    }

    @Test
    public void testSession()
    {
        //Map<String,String> m = new HashMap<String,String>();
        //m.put("Content-Type", "application/json");
        //m.put("cookie", "JESSIONID="+sessionCookie+"");
        Response responforAddBug = given().header("Content-Type","application/json")
                .cookie("JSESSIONID", sessionCookie).body(Payload.AddJIRABug("AttachmentBugTestQAQA")).log().all().when().post("/rest/api/2/issue")
                ;
        System.out.println(responforAddBug.getBody().asPrettyString());
        getJIRAID = Integer.parseInt(responforAddBug.getBody().jsonPath().getString("id"));
        System.out.println(getJIRAID);

    }

    @DataProvider(name="qaJIRATest")
    public Object[] getDataJIRASummary()
    {
        return new Object[] {"QATest1"};
    }

    @Test(dependsOnMethods = {"testSession"})
    public void addCommentInBug()
    {
        Response responforAddBug = given().log().all().header("content-type", "application/json").cookie("JSESSIONID", sessionCookie).body(Payload.addCommentToJIRA())
                .when().post("/rest/api/2/issue/"+getJIRAID+"/comment");
        int commentID = Integer.parseInt(responforAddBug.getBody().jsonPath().getString("id"));
        String commentString = responforAddBug.getBody().jsonPath().getString("body");
        System.out.println(responforAddBug.getBody().jsonPath().prettify());
    }

    @Test(dependsOnMethods = {"testSession"})
    public void testAddAttachmentToABug()
    {
        Response responeForAttachAttachment = given().log().all().header("X-Atlassian-Token", "no-check")
                .header("Content-Type", "multipart/form-data")
                .multiPart("file", new File("D:\\08072023\\testQAAutomation\\src\\test\\resources\\jira.txt")).cookie("JSESSIONID", sessionCookie)
                .when().log().all().post("/rest/api/2/issue/"+getJIRAID+"/attachments");
        String commentStringAttachment = responeForAttachAttachment.getBody().asPrettyString();
        System.out.println(commentStringAttachment);
    }

    @Test
    public void testGetAllIssuesType()
    {
        Response getAllIssueType = given().log().all().cookie("JSESSIONID", sessionCookie).when().get("/rest/api/2/issuetype");
        System.out.println(getAllIssueType.getBody().jsonPath().prettify());

    }

    @Test
    public void testGetPriotity()
    {
        Response getAllpriority = given().log().all().cookie("JSESSIONID", sessionCookie).when().get("/rest/api/2/priority");
        System.out.println(getAllpriority.getBody().jsonPath().prettify());
    }

}
