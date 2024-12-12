package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.payloads.Store;
import org.example.payloads.User;
import org.example.requests.StoreApi;
import org.example.requests.UserApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCreationStepDefs {

    @Given("User logs into the system")
    public void user_logs_into_the_system() {
        User payload = new User(
                1,
                "testing",
                "testname",
                "testsurname",
                "example@mail.com",
                "password",
                "+123456",
                1
        );
        Response postResponse = UserApi.postUser(payload);
        String username = payload.getUsername();
        String password = payload.getPassword();
        Response getResponse = UserApi.getUserLogin(username, password);

        assertEquals(200, postResponse.getStatusCode());
        assertEquals(200, getResponse.getStatusCode());
    }

    @When("User creates a new order")
    public void user_creates_a_new_order() {
        Store payload = new Store(
                123,
                20,
                1,
                "2024-12-12",
                Store.Status.PLACED,
                true
        );

        Response postResponse = StoreApi.postOrder(payload);

        assertEquals(200, postResponse.getStatusCode());
    }

    @Then("User logs out from the system")
    public void user_logs_out_from_the_system() {
        Response getResponse = UserApi.getUserLogout();

        assertEquals(200, getResponse.getStatusCode());
    }
}
