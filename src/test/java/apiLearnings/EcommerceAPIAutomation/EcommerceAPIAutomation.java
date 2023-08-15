package apiLearnings.EcommerceAPIAutomation;

import  AllPOJODefinitions.EcommerceAPIsPOJO.LoginResponse;
import ResourceConstants.APIConstant;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EcommerceAPIAutomation {

    String access_token;
    String user_id;
    @BeforeMethod
    public void getAccessTokenWithValidCredentials()
    {
        Map<String,String> authorizationPassword = new HashMap<String,String>();
        authorizationPassword.put("userEmail", "automationqa@java.com");
        authorizationPassword.put("userPassword", "Kamakshi@2025");
        RequestSpecification specRequest = new RequestSpecBuilder().
                setBaseUri(APIConstant.BASE_URI_RS).setContentType(ContentType.JSON).build();
        /*Request Builder by using Request Specification*/
        RequestSpecification res = given().spec(specRequest).body(authorizationPassword);
        LoginResponse response = res.
                when().log().all().
                post("/api/ecom/auth/login").
                then().extract().response().as(LoginResponse.class);
        access_token = response.getToken();
        user_id = response.getUserId();

    }

    @Test
    public void getAddOrder()
    {
        RequestSpecification specRequestHeaders = new RequestSpecBuilder().
                setBaseUri(APIConstant.BASE_URI_RS).addHeader("Authorization", access_token).build();
        Map<String,String> produtDetails = new HashMap<String,String>();
        produtDetails.put("productName", "automationqa@java.com");
        produtDetails.put("productAddedBy",user_id );
        produtDetails.put("productCategory", "automationqa@java.com");
        produtDetails.put("productSubCategory", "Kamakshi@2025");
        produtDetails.put("productPrice", "automationqa@java.com");
        produtDetails.put("productDescription", "Kamakshi@2025");
        produtDetails.put("productFor", "automationqa@java.com");
        produtDetails.put("productImage", "https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649434146.jpeg");
        RequestSpecification reqProduct = given().log().all().spec(specRequestHeaders).body(produtDetails);
        String responseForAProudct = reqProduct.when().log().all().
                post("/api/ecom/user/add-to-cart").then().log().all().extract().response().asString();
        System.out.println(responseForAProudct);
    }

}
