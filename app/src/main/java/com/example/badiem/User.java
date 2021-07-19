package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class User extends AppCompatActivity {

    Button btnLogin;
    TextInputLayout edtUsername,edtPassword;
    Hash hash = new Hash();
    String encryptedStr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user);

        btnLogin = findViewById(R.id.btnLogin);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        //String pass = edtPassword.getEditText().getText().toString().trim();
        //String acc = edtUsername.getEditText().getText().toString().trim();
        //String finalStr = txtUser.getText().toString() + "-" + txtPass.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //// TODO: 17/07/2021 So sánh

                if (!validate()) {
                    return;
                }
                else {
                    //// TODO: Check User exist and login

                    final String usernameEntered = edtUsername.getEditText().getText().toString();
                    final String passwordEntered = edtPassword.getEditText().getText().toString();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
                    Query checkUser = reference.orderByChild("username").equalTo(usernameEntered);

                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {

                                edtUsername.setError(null);
                                edtUsername.setErrorEnabled(false);

                                String passDB = snapshot.child(usernameEntered).child("password").getValue(String.class);
                                // check pass(User)
                                // Successsssssssss
                                encryptedStr = hash.getSHA512(passwordEntered);
                                if (passDB.equals(encryptedStr)) {
                                    System.out.println("Encrypted: " + encryptedStr);
                                    System.out.println("Check: " + hash.getSHA512(passwordEntered));
                                    edtUsername.setError(null);
                                    edtUsername.setErrorEnabled(false);
                                    String usernameDB = snapshot.child(usernameEntered).child("username").getValue(String.class);

                                    //start menu
                                    Intent intentmenu = new Intent(User.this,Menu.class);
                                    intentmenu.putExtra("username",usernameDB);
                                    intentmenu.putExtra("password",passDB);
                                    startActivity(intentmenu);
                                } else {
                                    edtPassword.setError("Wrong password");
                                    edtPassword.requestFocus();

                                }
                            } else {
                                edtUsername.setError("Not exist");
                                edtUsername.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }

    private Boolean validate() {
        String pass = edtPassword.getEditText().getText().toString();
        String acc = edtUsername.getEditText().getText().toString();
        if (pass.isEmpty()) {
            edtPassword.setError("Field cannot be empty");
            return false;
        }
        if(acc.isEmpty()){
            edtUsername.setError("Field cannot be empty");
            return false;
        }
        return true;
    }
}
