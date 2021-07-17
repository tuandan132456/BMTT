package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class User extends AppCompatActivity {

    Button btnLogin;
    EditText txtPass, txtUser;
    Hash hash = new Hash();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);

        mapping();
        String finalStr = txtUser.getText().toString() + "-" + txtPass.getText().toString();
        String encryptedStr = hash.getSHA512(finalStr);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //// TODO: 17/07/2021 So sánh
                System.out.println("Encrypted: " + encryptedStr);
            }
        });
    }

    private void mapping() {
        btnLogin = findViewById(R.id.btnLogin);
        txtPass = findViewById(R.id.txtPassword);
        txtUser = findViewById(R.id.txtUsername);
    }
}