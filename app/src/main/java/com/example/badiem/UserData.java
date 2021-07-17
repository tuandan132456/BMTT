package com.example.badiem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {
    public String fullname,username,password,phone,dateNow,infoEncrypted;

    public String getUsername() {
        return username;
    }


    public UserData(){

    }

    public UserData(String fullname,  String password,String phone,String dateNow ,String username){
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.dateNow = dateNow;
        this.username = username;
    }
}
