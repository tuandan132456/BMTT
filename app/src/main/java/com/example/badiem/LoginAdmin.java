package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginAdmin extends AppCompatActivity {

    DatabaseReference mData;
    
    private Button btnLogin;
    private EditText txtPass, txtUserName;
    Hash hash = new Hash();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        mData = FirebaseDatabase.getInstance().getReference();

        mapping();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 17/07/2021 đẩy lên db để so sánh - Vẫn chưa đc :v
                //String encrypted = Encrypt(UserName-Password)

                String encryptedStr = hash.getSHA512(txtPass.getText().toString());
                String userName = txtUserName.getText().toString();
                System.out.println(userName);
                System.out.println(encryptedStr);
                mData.child("User").child("Phong").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(Objects.requireNonNull(snapshot.getKey()).equals("password")){
                            if(Objects.requireNonNull(snapshot.getValue()).toString().equals(encryptedStr)){

                                Toast.makeText(LoginAdmin.this, "Success", Toast.LENGTH_SHORT).show();


                            }

                            else
                                Toast.makeText(LoginAdmin.this, "K dung pass", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginAdmin.this, "Khong dung username", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                    }
                });

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