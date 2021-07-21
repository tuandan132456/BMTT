package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.badiem.HelperClass.HomeAdapter.HistoryHelpersClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends AppCompatActivity {
    ImageView back;
    Button changePass,dangxuat,mission1,mission2,mission3,mission4,mission5;
    String DateTime,ActionName,username,password;
    DatabaseReference getAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);
        getAuth = FirebaseDatabase.getInstance().getReference("LOG_Data");
        back = findViewById(R.id.btnMenuBack);
        //back.setVisibility(View.GONE);
        changePass = findViewById(R.id.changePass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showprofile();
            }
        });
        Intent intent = getIntent();

        username = intent.getStringExtra("username");
        shareData a = shareData.getInstance();
        a.setStr(username);
        dangxuat = findViewById(R.id.signout);
        dangxuat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date date = new Date();

                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                DateTime  = df.format(date);
                ActionName = "Dang Xuat";
                HistoryHelpersClass historyHelpersClass = new HistoryHelpersClass(username,ActionName,DateTime);
                checkSwitch check = checkSwitch.getReference();
                if(check.getCheck()==1)
                {
                    getAuth.push().setValue(historyHelpersClass);
                }

                else
                {
                    Toast.makeText(Menu.this,"Log out !",Toast.LENGTH_LONG).show();
                }

                onBackPressed();
            }
        });
        mission1 = findViewById(R.id.mission1);
        mission2 = findViewById(R.id.mission2);
        mission3 = findViewById(R.id.mission3);
        mission4 = findViewById(R.id.mission4);
        mission5 = findViewById(R.id.mission5);

        mission1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(),Mission1.class);
                startActivity(intent1);
            }
        });
        mission2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent(getApplication(),Mission2.class);
                startActivity(intent1);
            }
        });
        mission3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent(getApplication(),Mission3.class);
                startActivity(intent1);
            }
        });
        mission4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent(getApplication(),Mission4.class);
                startActivity(intent1);
            }
        });
        mission5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent(getApplication(),Mission5.class);
                startActivity(intent1);
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