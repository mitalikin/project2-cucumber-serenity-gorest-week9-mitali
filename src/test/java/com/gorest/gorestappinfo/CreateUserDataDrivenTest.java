package com.gorest.gorestappinfo;

import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

//@Concurrent(threads="2x")
//@UseTestDataFrom("src/test/java/resources/testdata/gorestinfo.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class CreateUserDataDrivenTest extends TestBase {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
    @Steps
    UserSteps userSteps;
    @Title("Data driven test for adding multiple user to the application")
    @Test
    public void createMultipleUsers(){
        userSteps.createUser(name,email,gender,status).statusCode(201);
    }

}
