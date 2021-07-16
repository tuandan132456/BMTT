package com.example.badiem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogData {
    public String username,action,details;

    Date date = new Date();

    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    String dateNow  = df.format(date);

    public LogData(){

    }
    public LogData(String username,String action,  String details,String dateNow){
        this.username = username;
        this.action = action;
        this.details = details;
        this.dateNow = dateNow;
    }
}
