package com.example.badiem.HelperClass.HomeAdapter;

import android.widget.Switch;

public class FeaturedHelpersClass {

    int image, image1, image2;
    String  username;
    Switch aSwitch;

    public FeaturedHelpersClass(int image, String username, int image1, int image2, Switch aSwitch) {
        this.image = image;
        this.username = username;
        this.image1 = image1;
        this.image2 = image2;
        this.aSwitch = aSwitch;


    }

    public int getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public boolean getaSwitch(){ return false;}

    public void setImage(int image) {
        this.image = image;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setaSwitch(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }
}
