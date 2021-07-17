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
}
