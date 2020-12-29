package com.example.pesticidebe.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.NotBlank;

// THIS IS THE MODEL OF WHAT A TICKET SHOULD BE!

public class Ticket {

    private final long id;

    @NotBlank
    private final String title;
    private String description = "";

    public Ticket(@JsonProperty("id") long id,
                  @JsonProperty("title") String title,
                  @JsonProperty("description") String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
