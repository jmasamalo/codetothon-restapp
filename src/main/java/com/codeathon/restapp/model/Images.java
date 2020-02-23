package com.codeathon.restapp.model;

import java.io.Serializable;

public class Images implements Serializable {
    private String icon, medium, large, squareMedium, squareLarge;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSquareMedium() {
        return squareMedium;
    }

    public void setSquareMedium(String squareMedium) {
        this.squareMedium = squareMedium;
    }

    public String getSquareLarge() {
        return squareLarge;
    }

    public void setSquareLarge(String squareLarge) {
        this.squareLarge = squareLarge;
    }
}
