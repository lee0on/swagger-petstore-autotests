package Mocking;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;
import org.example.payloads.User;
import org.example.requests.UserApi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMockingTest {
    private static WireMockServer authMock;

    @BeforeAll
    public static void setAuthMock(){
        authMock = new WireMockServer(options().port(8080));
        authMock.start();
    }

    @AfterAll
    public static void killMock(){
        authMock.stop();
    }

    @Test
    public void getUserReturnsBodyAfter200(){
        authMock.stubFor(get(urlEqualTo("/user/testing"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": 1, \"username\": \"testing\", \"firstName\": \"testname\", \"lastName\": \"testsurname\", \"email\": \"example@mail.com\", \"password\": \"password\", \"phone\": \"+123456\", \"userStatus\": 1 }")));


        Response getResponse = UserApi.getUser("testing");
        User gottenUser =
                getResponse.as(User.class);
        assertAll("Проверка тела на валидный GET запрос",
                () -> assertEquals(1, gottenUser.getId()),
                () -> assertEquals("testing", gottenUser.getUsername()),
                () -> assertEquals("testname", gottenUser.getFirstName()),
                () -> assertEquals("testsurname", gottenUser.getLastName()),
                () -> assertEquals("example@mail.com", gottenUser.getEmail()),
                () -> assertEquals("password", gottenUser.getPassword()),
                () -> assertEquals("+123456", gottenUser.getPhone()),
                () -> assertEquals(1, gottenUser.getUserStatus())
                );
    }
}
