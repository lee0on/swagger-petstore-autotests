package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags {

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;

    public Tags() {}

    public Tags(int id, String name){
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
