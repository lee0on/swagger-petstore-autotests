package org.example.checks;

import io.restassured.response.Response;
import org.example.payloads.User;
import org.example.requests.UserApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User payload;

    @BeforeEach
    public void setPayload(){
        payload = new User(
                1,
                "testing",
                "testname",
                "testsurname",
                "example@mail.com",
                "password",
                "+123456",
                1
        );
    }

    @Test
    public void postAndGetUserReturns200(){
        Response response = UserApi.postUser(payload);
        assertEquals(200, response.getStatusCode());

        String username = payload.getUsername();
        Response getUserResponse = UserApi.getUser(username);
        assertEquals(200, getUserResponse.getStatusCode());
    }

    @Test
    public void deleteAndGetUserReturns200And404(){
        UserApi.postUser(payload);
        String username = payload.getUsername();
        Response deleteResponse = UserApi.deleteUser(username);
        assertEquals(200, deleteResponse.getStatusCode());

        Response getUserResponse = UserApi.getUser(username);
        assertEquals(404, getUserResponse.getStatusCode());
    }

    @Test
    public void getUserLoginReturns200(){
        UserApi.postUser(payload);
        String username = payload.getUsername();
        String password = payload.getPassword();

        Response getLoginResponse = UserApi.getUserLogin(username, password);
        assertEquals(200, getLoginResponse.getStatusCode());
    }

    @Test
    public void putUserReturns200(){
        UserApi.postUser(payload);
        String username = payload.getUsername();

        User newPayload = new User(
                5,
                "newtesting",
                "samplename",
                "samplesurname",
                "example@domain.com",
                "admin",
                "+654321",
                1
        );
        Response putResponse = UserApi.putUser(newPayload, username);
        assertEquals(200, putResponse.getStatusCode());
    }
}