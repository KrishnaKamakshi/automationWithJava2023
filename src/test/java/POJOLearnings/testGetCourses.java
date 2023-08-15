package POJOLearnings;

import LearningPOJO.GetCourses;
import ResourceConstants.APIConstant;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class testGetCourses {

    public static void main(String[] args) {

        GetCourses responseOfGetCourse = given().
                queryParam("access_token", "ya29.a0AbVbY6N0eqAUgI3UIqSGFAr0io6-X8RF_SvHn9y3y4jrV2mfNIwvoJioL0M22ziKUB0U5B35zl0NkJVV-YNwXWRtcBrYhsnvxIZm2Cv3eLpMNaqnQg35WUfUJ5xCaeDUSUlojL7-MMAR10M6qqskuGIWZyC_aCgYKAbUSARESFQFWKvPloYwl59PjYHwHukmaxzFz5w0163")
                .expect().defaultParser(Parser.JSON).log().all()
                .when().get(APIConstant.RAHUL_SHETTY).as(GetCourses.class);
        String value = responseOfGetCourse.getLinkedIn();
        System.out.println(value);
        //System.out.println(responseOfGetCourse);

    }
}
