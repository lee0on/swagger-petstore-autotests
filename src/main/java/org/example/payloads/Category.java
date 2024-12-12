package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;

    public Category() {}

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
