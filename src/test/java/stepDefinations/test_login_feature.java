package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class test_login_feature {
    @Given("^User is on Landing Page$")
    public void get_login_page()
    {
        System.out.println("Test 1");
    }
    @When("User login into the application with user email as {string} and password {string}")
    public void user_login_into_the_application_with_user_email_as_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test 4");
    }
    @Then("^Home Page should be displayed$")
    public void get_login_page_3()
    {
        System.out.println("Test 3");
    }
    @And("^Cards are displayed$")
    public void getCardsPage()
    {
        System.out.println("Test 4");
    }
}
