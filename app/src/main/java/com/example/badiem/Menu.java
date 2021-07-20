package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.badiem.HelperClass.HomeAdapter.HistoryHelpersClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends AppCompatActivity {
    ImageView back;
    Button changePass,dangxuat;
    String DateTime,ActionName,username,password;
    DatabaseReference getAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getAuth = FirebaseDatabase.getInstance().getReference("LOG_Data");
        back = findViewById(R.id.btnMenuBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        changePass = findViewById(R.id.changePass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showprofile();
            }
        });
        Intent intent = getIntent();

        username = intent.getStringExtra("username");
        dangxuat = findViewById(R.id.signout);
        dangxuat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date date = new Date();

                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                DateTime  = df.format(date);
                ActionName = "Dang Xuat";
                HistoryHelpersClass historyHelpersClass = new HistoryHelpersClass(username,ActionName,DateTime);
                getAuth.push().setValue(historyHelpersClass);

                onBackPressed();
            }
        });
    }
    public  void showprofile(){
        Intent intent = getIntent();

        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");
        Intent intent1 = new Intent(getApplication(), Profile.class);
        intent1.putExtra("username",username);
        intent1.putExtra("password",password);
        startActivity(intent1);
    }
}