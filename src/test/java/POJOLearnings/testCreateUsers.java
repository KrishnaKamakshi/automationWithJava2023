package POJOLearnings;

import ResourceConstants.APIConstant;
import RestReqWebsiteAPIs.CreateUsersTest;
import RestReqWebsiteAPIs.ResponseOfCreateUsers;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testCreateUsers {
    @Test
    public void testCreationOfUsers() {

        CreateUsersTest usersDemo = new CreateUsersTest();
        ResponseOfCreateUsers getUserInfo = new ResponseOfCreateUsers();
        usersDemo.setName("Krishna Kamakshi Brahma");
        usersDemo.setJob("Quality Analyst");
        Response responseOfAddedUser = given().body(usersDemo).log().all()
                .when().post(APIConstant.CREATE_USER_EMAIL)
                .then().assertThat().statusCode(201).extract().response();

        System.out.println(responseOfAddedUser.getBody().prettyPrint());
        String getIDForUser = responseOfAddedUser.getBody().jsonPath().getString("id");
        System.out.println(getIDForUser);

        /*
         * Using Response Spec Builder and Request Builder for code optimization
         */
       RequestSpecification specRequest = new RequestSpecBuilder().
               setBaseUri(APIConstant.BASE_URI_REQRES).build();
       /*Request Builder by using Request Specification*/
       RequestSpecification res = given().spec(specRequest).body(usersDemo);
       /*Response Builder by using Request Specification*/
       ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(201).build();
       Response response1= res.when().post(APIConstant.CREATE_USER_EMAIL)
                .then().spec(respSpec).extract().response();
       System.out.println(response1.getBody().prettyPrint());
       String getIDForUser2 = response1.getBody().jsonPath().getString("id");
       System.out.println(getIDForUser);

    }


}
