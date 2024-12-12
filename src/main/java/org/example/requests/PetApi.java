package org.example.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.payloads.Pet;

import static io.restassured.RestAssured.given;

public class PetApi {

    public static final String apiUrl =
            "https://petstore.swagger.io/v2";

    public static Response postPet(Pet payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl + "/pet");
    }

    public static Response getPetById(int id){
        return given()
                .when()
                .get(apiUrl + "/pet/" + id);
    }

    public static Response deletePet(int id){
        return given()
                .when()
                .delete(apiUrl + "/pet/" + id);
    }

    public static Response deleteInvalidPet(){
        return given()
                .when()
                .delete(apiUrl + "/pet/test");
    }
}
