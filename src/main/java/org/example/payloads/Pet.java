package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pet {

    public enum Status {
        AVAILABLE("available"),
        PENDING("pending"),
        SOLD("sold");

        private final String value;

        Status(String value) {
            this.value = value;
        }
    }

    @JsonProperty
    private String name;
    @JsonProperty
    private List<String> photoUrls;
    @JsonProperty
    private int id;
    @JsonProperty
    private Category category;
    @JsonProperty
    private List<Tags> tags;
    @JsonProperty
    private Status status;

    public Pet() {}

    public Pet(String name, List<String> photoUrls, int id, Category category, List<Tags> tags, Status status){
        this.name = name;
        this.photoUrls = photoUrls;
        this.id = id;
        this.category = category;
        this.tags = tags;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public Status getStatus() {
        return status;
    }
}
