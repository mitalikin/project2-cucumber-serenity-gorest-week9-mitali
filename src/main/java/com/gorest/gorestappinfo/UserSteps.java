package com.gorest.gorestappinfo;

import com.gorest.constant.EndPoints;
import com.gorest.models.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserSteps {
    @Step("Creating User with name : {0}, email: {1}, gender: {3}, status: {3}")
    public ValidatableResponse createUser(String name,
                                          String email,
                                          String gender,
                                          String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);


        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805" )
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();
    }

    @Step("Getting the product information with id:{0}")
    public HashMap<String, Object> getProductInfoAddedByID(String name) {
        String p1 = "findAll{it.name == '";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .header("Authorization", "Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805")
                .when()
                .get(EndPoints.GET_ALL_USER)
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);

    }

    @Step("Updating users information with name:{0},email:{1},gender:{2},status:{3}")
    public ValidatableResponse updateUser(int id,
                                          String name,
                                          String email,
                                          String gender,
                                          String status) {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805")
                .pathParam("id",id)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }
    @Step("Deleting user information with id: {0}")

    public ValidatableResponse deleteUser(int id){
        return  SerenityRest.given().log().all()
                .header("Authorization", "Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805")
                .pathParam("id",id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
    @Step("Getting student information with studentId: {0}")
    public ValidatableResponse getUserById(int id){
        return  SerenityRest.given().log().all()
                .header("Authorization", "Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805")
                .pathParam("id",id)
                .when()
                .get(EndPoints.GET_USER_BY_ID)
                .then()
                .statusCode(404);
    }
    @Step("Getting All user Information")
    public  ValidatableResponse getAllUserInfo(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_USER)
                .then();
    }
}