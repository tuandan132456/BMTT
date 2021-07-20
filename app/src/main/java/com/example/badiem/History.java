package com.example.badiem;

import android.se.omapi.Session;
import android.view.SurfaceControl;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class History {
    private boolean audit = MainActivity.isAuditing;


    public static void addHistory(LogData logData){
        DatabaseReference mData = FirebaseDatabase.getInstance().getReference();
        mData.child("User History").push().setValue(logData);
    }

//    public static LogData[] histories(){
//        return list lịch sử
//    }

}
