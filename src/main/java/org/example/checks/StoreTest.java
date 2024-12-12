package org.example.checks;

import io.restassured.response.Response;
import org.example.payloads.InvalidResponse;
import org.example.payloads.Store;
import org.example.requests.StoreApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void getInventoryReturns200(){
        Response response = StoreApi.getInventory();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getOrderReturns200(){
        Response response = StoreApi.getOrder();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postOrderReturns200(){
        Store payload = new Store(
                123,
                20,
                1,
                "2024-12-12",
                Store.Status.PLACED,
                true
        );

        Response response = StoreApi.postOrder(payload);
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void deleteOrderReturns200(){
        Store payload = new Store(
                123,
                20,
                1,
                "2024-12-12",
                Store.Status.PLACED,
                true
        );

        Response response = StoreApi.postOrder(payload);
        Store createdStore =
                response.as(Store.class);
        Response deleteResponse = StoreApi.deleteOrder(
            createdStore.getId()
        );
        assertEquals(200, deleteResponse.getStatusCode());
    }

    @Test
    public void getInvalidOrderReturns404AndBody(){
        Response response = StoreApi.getInvalidOrder();
        InvalidResponse createdStore =
                response.as(InvalidResponse.class);

        assertAll("Проверка тела ответа на невалидный GET запрос",
                () -> assertEquals(404, response.getStatusCode()),
                () -> assertEquals(404, createdStore.getCode()),
                () -> assertEquals("error", createdStore.getType()),
                () -> assertEquals("Order not found", createdStore.getMessage())
        );

    }

    @Test
    public void deleteInvalidOrderReturns404AndBody(){
        Response response = StoreApi.deleteInvalidOrder();
        InvalidResponse createdStore =
                response.as(InvalidResponse.class);

        assertAll("Проверка тела ответа на невалидный DELETE запрос",
                () -> assertEquals(404, response.getStatusCode()),
                () -> assertEquals(404, createdStore.getCode()),
                () -> assertEquals("error", createdStore.getType()),
                () -> assertEquals("Order not found", createdStore.getMessage())
                );
    }

    @Test
    public void postInvalidOrderReturns400(){
        Store payload = new Store(
                -123,
                -20,
                -1,
                "2024-12-12",
                Store.Status.PLACED,
                true
        );

        Response response = StoreApi.postOrder(payload);
        assertEquals(400, response.getStatusCode());
    }
}
