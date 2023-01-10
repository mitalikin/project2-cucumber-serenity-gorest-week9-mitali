package com.gorest.cucumber.steps;

import com.gorest.gorestappinfo.UserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    static ValidatableResponse response;
    static int userID;
    static String name;
    @Steps
    UserSteps userSteps;
    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response= userSteps.getAllUserInfo();
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
      response.statusCode(200);
    }

    @When("^I create a new user by providing the information name\"([^\"]*)\" email \"([^\"]*)\" gender \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationNameEmailGenderStatus(String name, String email, String gender, String status) {
       response=userSteps.createUser(name,email,gender,status);
    }
  @Then("^I verify that the user with \"([^\"]*)\" is created$")
    public void iVerifyThatTheUserWithIsCreated(String name) {
//        HashMap<String, Object> studentMap = userSteps.getProductInfoAddedByID(name);
//        userID = (int) studentMap.get("id");
//        Assert.assertThat(studentMap, hasValue(name));
    }


    @Given("^user application is running$")
    public void userApplicationIsRunning() {
    }

    @And("^I update the user with information name\"([^\"]*)\"email\"([^\"]*)\"gender\"([^\"]*)\"status\"([^\"]*)\"$")
    public void iUpdateTheUserWithInformationNameEmailGenderStatus(String name, String email, String gender, String status)  {
name=name+"_updated";
response=userSteps.updateUser(userID,name,email,gender,status);
    }


    @And("^The user with name\"([^\"]*)\" is updated successfully$")
    public void theUserWithNameIsUpdatedSuccessfully(String name)  {
        HashMap<String,Object> studentMap = userSteps.getProductInfoAddedByID(name);
        Assert.assertThat(studentMap, hasValue(name));
    }

    @And("^I delete the user that created with name\"([^\"]*)\"$")
    public void iDeleteTheUserThatCreatedWithName(String name)  {
        response = userSteps.deleteUser(userID);
    }

    @Then("^The user deleted successfully from application$")
    public void theUserDeletedSuccessfullyFromApplication() {
        response.statusCode(204);
        userSteps.getUserById(userID).statusCode(404);
    }



}

