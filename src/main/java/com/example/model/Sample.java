package com.example.model;

public class Sample {

    private final Long id;
    private final String message;

    public Sample(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
