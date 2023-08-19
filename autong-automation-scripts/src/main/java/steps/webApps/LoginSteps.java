package steps.webApps;

import com.autong.base.TestBase;
import forms.LoginTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class LoginSteps {

    LoginTests loginTests;

    @Given("user is redirected to login url")
    public void openUrl() {
        loginTests = new LoginTests(TestBase.getDriver());
        loginTests.openUrl();
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginTests = new LoginTests(TestBase.getDriver());
        loginTests.enterCredentials(username, password);
    }

    @And("user clicks on login button")
    public void clickLogin() {
        loginTests = new LoginTests(TestBase.getDriver());
        loginTests.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void verifyDashboardLogo() {
        loginTests = new LoginTests(TestBase.getDriver());
        loginTests.verifyDashboardLogo();
    }
}
