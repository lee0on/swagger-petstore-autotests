package org.example.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.payloads.Store;

import static io.restassured.RestAssured.given;

public class StoreApi {

    private static final String apiUrl =
            "https://petstore.swagger.io/v2";

    public static Response getInventory(){
        return given()
                .when()
                .get(apiUrl + "/store/inventory");
    }

    public static Response getOrder(){
        return given()
                .when()
                .get(apiUrl + "/store/order/100");
    }

    public static Response postOrder(Store payload){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl + "/store/order");
    }

    public static Response deleteOrder(int id){
        return given()
                .when()
                .delete(apiUrl + "/store/order/" + id);
    }

    public static Response getInvalidOrder(){
        return given()
                .when()
                .get(apiUrl + "/store/order/0");
    }

    public static Response deleteInvalidOrder(){
        return given()
                .when()
                .delete(apiUrl + "/store/order/0");
    }
}