package apiLearnings.POJOLearnings;

import ResourceConstants.APIConstant;
import AllPOJODefinitions.RestReqWebsiteAPIs.DataUsers;
import AllPOJODefinitions.RestReqWebsiteAPIs.ListUsers;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class testReqResListUsersExample {
    Logger log = Logger.getLogger(testReqResListUsersExample.class);
    @Test
    public void getTestListOfUsers(){
        RestAssured.baseURI= APIConstant.BASE_URI_REQRES;
        ListUsers responseOfGetUsers = given().log().all()
                .queryParams("page","2")
                .when().get(APIConstant.URL_GET_USER_LIST).as(ListUsers.class);
        log.info("REST URI is generated");
        int value = responseOfGetUsers.getTotal();
        System.out.println(value);
        System.out.println(responseOfGetUsers.getData().get(1).getFirst_name());

        //Scan of the Data
        List<DataUsers> getNames = responseOfGetUsers.getData();
        for (int i=0; i<getNames.size(); i++)
        {
            if(Objects.equals(responseOfGetUsers.getData().get(i).getFirst_name(), "Lindsay1"))
            {
                System.out.println(responseOfGetUsers.getData().get(i).getAvatar());
            }
        }
    }
}
