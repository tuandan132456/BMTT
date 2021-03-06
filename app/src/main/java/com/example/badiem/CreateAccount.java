package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
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
    EncryptAndHash encryptAndHash = new EncryptAndHash();

    Button btnCreate;
    TextInputLayout fullname,username,phone,pass,confirmpass;
    String FullName,UserName,PhoneNo,PassWord,ConfirmPassword,DateTime;
    ImageView back;
    DatabaseReference fAuth,getfAuth;
    Boolean b = MainActivity.isAuditing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_create_account);

        System.out.println("Value: " + b);
        back = findViewById(R.id.btnBackAdmin);
        fullname = findViewById(R.id.txtFullname);
        username = findViewById(R.id.txtUsername);
        phone   = findViewById(R.id.txtPhone);
        pass = findViewById(R.id.txtPassword);
        confirmpass = findViewById(R.id.txtConfirmPass);




        //getfAuth = FirebaseDatabase.getInstance().getReference("LOG");
        //getfAuth.setValue("day la log");
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

        //// TODO: 17/07/2021 L??m sao ????? ?????y c??i pass encrypted l??n?? Done
        FullName = fullname.getEditText().getText().toString().trim();
        UserName = username.getEditText().getText().toString().trim();
        PhoneNo = phone.getEditText().getText().toString().trim();
        PassWord = encryptAndHash.Encrypter(pass.getEditText().getText().toString().trim());
        Date date = new Date();


        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        DateTime  = df.format(date);

        UserData userData = new UserData(FullName,PassWord,PhoneNo,DateTime,UserName);

        fAuth.child(UserName).setValue(userData);

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