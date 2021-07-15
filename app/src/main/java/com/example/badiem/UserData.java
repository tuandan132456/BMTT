package com.example.badiem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {
    public String fullname,username,password,phone,dateNow;

    public UserData(){

    }

    public UserData(String fullname, String username, String password,String phone, String dateNow){
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.dateNow = dateNow;
    }
}
