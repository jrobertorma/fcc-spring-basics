package com.example.fcctutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    //Field declaration
    private final UUID id;
    private final String name;

    /*
    * Constructor of the fields, we use @JsonProperty to indicate we expect
    * a JSON prop from the client call (I'm going to use postman to simulate the request)
    * */
    public Person(@JsonProperty ("id") UUID id,
                  @JsonProperty ("name") String name) {
        this.id = id;
        this.name = name;
    }

    //field getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
