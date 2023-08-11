package steps.restAPIs;

import com.autong.base.Assertions;
import com.autong.base.RestResources;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UsersSteps {

    Response response;

    @When("user executes post call to add test result")
    public void postAddTestResult() {
        response = RestResources.get("https://reqres.in", "/api/users");
        System.out.println(response.asPrettyString());
    }

    @Then("user should be able to receive a valid response")
    public void validateResponse() {
        Assertions.validateOkResponse(response);
        Assertions.validateResponseTime(response);
    }
}
