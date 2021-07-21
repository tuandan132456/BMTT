package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class Admin extends AppCompatActivity {
    Button btnListUser, btnCreateAcc, btnAuditing;
    ImageView imv,back;
    Switch battat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);
        btnListUser = findViewById(R.id.btnListt);
        btnCreateAcc = findViewById(R.id.btnCreateAccount);
        btnAuditing = findViewById(R.id.btnAuditing);
        imv = findViewById(R.id.imvRec);
        back = findViewById(R.id.adminback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnAuditing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Log_history.class);
                startActivity(intent);
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
                Intent intentt = new Intent(Admin.this, ListUser.class);
                startActivity(intentt);
            }
        });
        Switch switch1 = (Switch) findViewById(R.id.switchbutton);
        checkSwitch checkau = checkSwitch.getReference();
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    checkau.setCheck(1);
                else
                    checkau.setCheck(0);
            }
        });
        int au = checkau.getCheck();
        if(au ==1)
            switch1.setChecked(true);
        else
            switch1.setChecked(false);

    }
}