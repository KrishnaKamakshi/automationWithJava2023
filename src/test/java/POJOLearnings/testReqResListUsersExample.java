package POJOLearnings;

import ResourceConstants.APIConstant;
import RestReqWebsiteAPIs.DataUsers;
import RestReqWebsiteAPIs.ListUsers;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class testReqResListUsersExample {
    @Test
    public void getTestListOfUsers() {
        RestAssured.baseURI = APIConstant.BASE_URI_REQRES;
        ListUsers responseOfGetUsers = given().log().all()
                .queryParams("page", "2")
                .when().get(APIConstant.URL_GET_USER_LIST).as(ListUsers.class);

        int value = responseOfGetUsers.getTotal();
        System.out.println(value);
        System.out.println(responseOfGetUsers.getData().get(1).getFirst_name());

        //Scan of the Data
        List<DataUsers> getNames = responseOfGetUsers.getData();
        for (int i = 0; i < getNames.size(); i++) {
            if (Objects.equals(responseOfGetUsers.getData().get(i).getFirst_name(), "Lindsay")) {
                System.out.println(responseOfGetUsers.getData().get(i).getAvatar());
            }
        }
    }
}
