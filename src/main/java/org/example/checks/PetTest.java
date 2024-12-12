package org.example.checks;

import io.restassured.response.Response;
import org.example.payloads.Category;
import org.example.payloads.Pet;
import org.example.payloads.Tags;
import org.example.requests.PetApi;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    public void postAndGetPetReturns200(){
        List<Tags> tagsList = Collections.singletonList(new Tags(
                1,
                "test"
        ));

        Category category = new Category(
                2,
                "testing"
        );

        Pet payload = new Pet(
                "testPet",
                Collections.singletonList("testPhoto"),
                3,
                category,
                tagsList,
                Pet.Status.PENDING
        );

        Response postResponse = PetApi.postPet(payload);
        Pet createdPet =
                postResponse.as(Pet.class);
        Response getResponse = PetApi.getPetById(createdPet.getId());

        assertEquals(200, postResponse.getStatusCode());
        assertEquals(200, getResponse.getStatusCode());
    }

    @Test
    public void deleteAndGetPetReturns200And404(){
        List<Tags> tagsList = Collections.singletonList(new Tags(
                1,
                "test"
        ));

        Category category = new Category(
                2,
                "testing"
        );

        Pet payload = new Pet(
                "testPet",
                Collections.singletonList("testPhoto"),
                3,
                category,
                tagsList,
                Pet.Status.PENDING
        );

        Response postResponse = PetApi.postPet(payload);
        Pet createdPet =
                postResponse.as(Pet.class);
        Response deleteResponse = PetApi.deletePet(createdPet.getId());
        Response getResponse = PetApi.getPetById(createdPet.getId());

        assertEquals(200, deleteResponse.getStatusCode());
        assertEquals(404, getResponse.getStatusCode());
    }

    @Test
    public void deleteInvalidPetReturns404AndHeaders(){
        Response deleteResponse = PetApi.deleteInvalidPet();
        assertEquals(404, deleteResponse.getStatusCode());

        assertAll("Проверка заголовков ответа",
                () -> assertEquals("GET, POST, DELETE, PUT", deleteResponse.getHeader("Access-Control-Allow-Methods")),
                () -> assertTrue(deleteResponse.getHeaders().hasHeaderWithName("Transfer-Encoding")));
    }
}
