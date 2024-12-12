package org.example.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.payloads.User;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String apiUrl =
            "https://petstore.swagger.io/v2";

//    private static final String apiUrl =
//            "http://localhost:8080";

    public static Response postUser(User payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl + "/user");

    }

    public static Response deleteUser(String username){
        return given()
                .when()
                .delete(apiUrl + "/user/" + username);
    }

    public static Response getUser(String username){
        return given()
                .when()
                .get(apiUrl + "/user/" + username);
    }

    public static Response getUserLogin(String username, String password){
        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get(apiUrl + "/user/login");
    }

    public static Response putUser(User newPayload, String username){
        return given()
                .contentType(ContentType.JSON)
                .body(newPayload)
                .when()
                .put(apiUrl + "/user/" + username);
    }

    public static Response getUserLogout(){
        return given()
                .when()
                .get(apiUrl + "/user/logout");
    }
}
