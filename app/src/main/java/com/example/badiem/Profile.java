package com.example.badiem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.badiem.HelperClass.HomeAdapter.HistoryHelpersClass;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Profile extends AppCompatActivity {
    Button update;
    ImageView back;
    TextView name;
    TextInputLayout passcu,newpass,confirm;
    String userDB,passDB,encryptPassCu;
    String DateTime,ActionName,username;
    DatabaseReference getAuth;
    Hash hash = new Hash();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.txtNameProfile);
        update = findViewById(R.id.btnUpdate);

        passcu = findViewById(R.id.edtPassProfile);
        newpass = findViewById(R.id.edtNewPass);
        confirm = findViewById(R.id.edtConfirmProfile);
        back = findViewById(R.id.PasswordBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getUser();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate()) {
                    return;
                }
                else {
                    //// TODO: Check User exist and login

                    String passwordEntered = passcu.getEditText().getText().toString();
                    encryptPassCu = hash.getSHA512(passwordEntered);
                    String passNew = newpass.getEditText().getText().toString().trim();
                    String mahoaPassNew = hash.getSHA512(passNew);
                    HashMap hashMap = new HashMap();
                    hashMap.put("password",mahoaPassNew);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
                    if(encryptPassCu.equals(passDB))
                    {
                        reference.child(userDB).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                Date date = new Date();

                                DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                                DateTime  = df.format(date);
                                ActionName = "Change Password";
                                HistoryHelpersClass historyHelpersClass = new HistoryHelpersClass(username,ActionName,DateTime);
                                checkSwitch check = checkSwitch.getReference();
                                if(check.getCheck()==1)
                                {
                                    getAuth.push().setValue(historyHelpersClass);
                                }

                                else {
                                    //Toast.makeText(Menu.this,"Log out !",Toast.LENGTH_LONG).show();

                                    Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    else{
                        passcu.setError("Wrong PassWord !!");
                        passcu.requestFocus();
                    }


                }
            }
        });
    }
    private void getUser() {
        Intent intent = getIntent();

        userDB = intent.getStringExtra("username");
        passDB = intent.getStringExtra("password");

        name.setText(userDB);
    }
    private Boolean validate() {
        String pass = newpass.getEditText().getText().toString();
        String oldpass = passcu.getEditText().getText().toString();
        if (pass.isEmpty()) {
            newpass.setError("Field cannot be empty");
            return false;
        }
        if(oldpass.isEmpty()){
            passcu.setError("Field cannot be empty");
            return false;
        }

        return true;
    }
}