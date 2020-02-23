package com.codeathon.restapp.model;

import java.io.Serializable;

public class BreweryResponse implements Serializable {
    private String message, status;
    private Brewery data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Brewery getData() {
        return data;
    }

    public void setData(Brewery data) {
        this.data = data;
    }
}
