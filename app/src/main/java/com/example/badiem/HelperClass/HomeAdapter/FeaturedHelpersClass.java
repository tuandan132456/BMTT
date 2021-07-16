package com.example.badiem.HelperClass.HomeAdapter;

public class FeaturedHelpersClass {

    int image;
    String  username, action, details, dateNow;

    public FeaturedHelpersClass(int image, String username, String action, String details, String dateNow) {
        this.image = image;
        this.username = username;
        this.action = action;
        this.details = details;
        this.dateNow = dateNow;
    }

    public int getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public String getAction() {
        return action;
    }

    public String getDetails() {
        return details;
    }

    public String getDateNow() {
        return dateNow;
    }
}
