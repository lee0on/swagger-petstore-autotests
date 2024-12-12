package org.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidResponse {

    @JsonProperty
    private int code;
    @JsonProperty
    private String type;
    @JsonProperty
    private String message;

    public InvalidResponse() {}

    public InvalidResponse(int code, String type, String message){
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
