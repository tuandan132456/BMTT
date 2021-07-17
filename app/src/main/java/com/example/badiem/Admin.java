package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Admin extends AppCompatActivity {
    Button btnListUser, btnCreateAcc, btnAuditing;
    ImageView imv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);
        btnListUser = findViewById(R.id.btnList);
        btnCreateAcc = findViewById(R.id.btnCreateAccount);
        btnAuditing = findViewById(R.id.btnAuditing);
        imv = findViewById(R.id.imvRec);


        btnAuditing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.isAuditing){
                    MainActivity.isAuditing = false;
                    imv.setVisibility(View.INVISIBLE);
                }
                else {
                    MainActivity.isAuditing = true;
                    imv.setVisibility(View.VISIBLE);
                }

            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this,CreateAccount.class);
                startActivity(intent);
            }
        });

        btnListUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this,List.class);
                startActivity(intent);
            }
        });
    }
}