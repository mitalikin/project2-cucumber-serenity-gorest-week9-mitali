package com.gorest.gorestappinfo;

import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

//@RunWith(SerenityRunner.class)
public class UserCRUDTestWithStep extends TestBase {
    static String name = "jasonBrown";
    static String email = "jas123" + TestUtils.getRandomValue() + "@gmail.com";
    static String gender = "female";
    static String status = "active";
   // static String token;
    static int userID;

    @Steps
    UserSteps userSteps;

    @Title("This will create a new User")
    @Test
    public void test001() {
        ValidatableResponse response = userSteps.createUser(name, email, gender, status);
        response.log().all().statusCode(201);

    }

    @Title("This will Fetch user by ID")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = userSteps.getProductInfoAddedByID(name);
        Assert.assertThat(userMap, hasValue(name));
        userID = (int) userMap.get("id");
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated";
        userSteps.updateUser(userID, name, email, gender, status).log().all().statusCode(200);
        HashMap<String, Object> userMap = userSteps.getProductInfoAddedByID(name);
        Assert.assertThat(userMap, hasValue(name));
    }

    @Title("Delete the user and verify if the user is deleted!")
    @Test
    public void test004() {
        userSteps.deleteUser(userID).statusCode(204);
        userSteps.getUserById(userID).statusCode(404);

    }


}




