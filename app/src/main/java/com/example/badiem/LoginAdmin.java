package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginAdmin extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtPass, txtUserName;
    Hash hash = new Hash();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        mapping();
        String finalStr = txtUserName.getText().toString() + "-" + txtPass.getText().toString();
        String encryptedStr = hash.getSHA512(finalStr);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 17/07/2021 đẩy lên db để so sánh
                //String encrypted = Encrypt(UserName-Password)
                System.out.println("Pass: " + encryptedStr);

                Intent it = new Intent(LoginAdmin.this, Admin.class);
                startActivity(it);
            }
        });
    }

    private void mapping() {
        btnLogin = findViewById(R.id.btnLogin);
        txtPass = findViewById(R.id.txtPassword);
        txtUserName = findViewById(R.id.txtUsername);
    }
}