package com.example.badiem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {
    public String name,username,password;

    Date date = new Date();

    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    String dateNow  = df.format(date);
    public UserData(){

    }

    public UserData(String name, String username, String password, String dateNow){
        this.name = name;
        this.username = username;
        this.password = password;
        this.dateNow = dateNow;
    }
}
