package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginAdmin extends AppCompatActivity {

    DatabaseReference mData;
    ImageView back;
    private Button btnLogin;
    private TextInputLayout txtPass, txtUserName;
    Hash hash = new Hash();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_admin);

        mData = FirebaseDatabase.getInstance().getReference();

        btnLogin = findViewById(R.id.btnLogin);
        txtPass = findViewById(R.id.edtAdminPass);
        txtUserName = findViewById(R.id.edtAdminPass);
        String Username = txtUserName.getEditText().getText().toString().trim();
        String Password = txtPass.getEditText().getText().toString().trim();
        back = findViewById(R.id.loginadminback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkAdmin(Username,Password))
                {
                    Toast.makeText(LoginAdmin.this,"Wronggggg",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    Intent intent = new Intent(LoginAdmin.this,Admin.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean checkAdmin(String a, String b){
        if(a.equals("admin"))
        {
            if(!b.equals("admin"))
                return false;
            else return true;
        }
        return true;

    }
}
