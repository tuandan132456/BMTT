package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccount extends AppCompatActivity {
    Button btnCreate;
    TextInputLayout fullname,username,phone,pass,confirmpass;
    String FullName,UserName,PhoneNo,PassWord,ConfirmPassword,DateTime;
    ImageView back;
    DatabaseReference fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        back = findViewById(R.id.btnBackAdmin);

        //tao data
        fAuth = FirebaseDatabase.getInstance().getReference("User");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Validation() ){
                    Toast.makeText(CreateAccount.this,"Faild",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
                    Query checkUser = reference.orderByChild("username").equalTo(UserName);

                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull  DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                username.setError("Username is already in use");
                                username.requestFocus();
                            } else {
                                CreateAccount();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull  DatabaseError error) {
                            //...
                        }
                    });
                }
            }
        });
    }
    public void CreateAccount(){
        FullName = fullname.getEditText().getText().toString().trim();
        UserName = username.getEditText().getText().toString().trim();
        PhoneNo = phone.getEditText().getText().toString().trim();
        PassWord = pass.getEditText().getText().toString().trim();
        Date date = new Date();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        DateTime  = df.format(date);

        UserData user = new UserData(FullName,UserName,PassWord,PhoneNo,DateTime);

        fAuth.child(UserName).setValue(user);

        Toast.makeText(CreateAccount.this,"Create Success",Toast.LENGTH_LONG).show();

        onBackPressed();
    }
    public boolean Validation(){
        FullName = fullname.getEditText().getText().toString().trim();
        UserName = username.getEditText().getText().toString().trim();
        PhoneNo = phone.getEditText().getText().toString().trim();
        PassWord = pass.getEditText().getText().toString().trim();
        ConfirmPassword = confirmpass.getEditText().getText().toString().trim();
        if(TextUtils.isEmpty(FullName)){
            fullname.setError("Fullname is Required");
            return false;
        }

        if(TextUtils.isEmpty(UserName)){
            username.setError("Username is Required");
            return false;
        }
        if(pass.getEditText().getText().length() < 8){
            pass.setError("Password must be >=8");
            return false;
        }
        if(!ConfirmPassword.equals(PassWord)){
            confirmpass.setError("Pass not matching !");
            return false;
        }
        if(phone.getEditText().getText().length()>10){
            phone.setError("Khong dung sdt");
            return false;
        }
        return true;
    }
}