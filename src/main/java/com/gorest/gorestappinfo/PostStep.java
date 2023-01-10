package com.gorest.gorestappinfo;

import com.gorest.models.PostPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostStep {
    @Step("Create post for userId:{0},title{1},body:{2}")
    public ValidatableResponse createPost(int userId,String title,String body){
        PostPojo postPojo=new PostPojo();
        postPojo.setUser_id(userId);
        postPojo.setTitle(title);
        postPojo.setBody(body);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Autorization","Bearer 25fb8bbd4e5fc3d6ae066205e102ec57d5a1341d5e3f20f4dd96aea34ad8b805")
                .pathParam("userId",userId)
                .body(postPojo)
                .when()
                .post()
                .then();
    }



}
