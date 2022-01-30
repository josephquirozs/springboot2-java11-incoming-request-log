package com.example.incomingrequestlog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
    @JsonProperty("to_person")
    private String toPerson;
    @JsonProperty("from_place")
    private String fromPlace;

    public String getToPerson() {
        return toPerson;
    }

    public void setToPerson(String toPerson) {
        this.toPerson = toPerson;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }
}
