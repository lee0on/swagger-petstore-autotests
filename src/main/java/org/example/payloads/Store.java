package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public class Store {

    public enum Status {
        PLACED("placed"),
        APPROVED("approved"),
        DELIVERED("delivered");

        private final String value;

        Status(String value) {
            this.value = value;
        }
    }

    @JsonProperty
    private int id;
    @JsonProperty
    private int petId;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private String shipDate;
    @JsonProperty
    private Status status;
    @JsonProperty
    private boolean complete;

    public Store() {}

    public Store(int id, int petId, int quantity, String shipDate, Status status, boolean complete){
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isComplete() {
        return complete;
    }
}
