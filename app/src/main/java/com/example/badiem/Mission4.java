package com.example.badiem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.badiem.HelperClass.HomeAdapter.HistoryHelpersClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//1B
//2B
//3A
//4A
//5C
public class Mission4 extends AppCompatActivity {
    Button submit;
    RadioGroup cau1,cau2,cau3,cau4,cau5;
    int dem=0;
    String DateTime,ActionName,username;
    DatabaseReference getAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mission4);
        getAuth = FirebaseDatabase.getInstance().getReference("LOG_Data");
        shareData b = shareData.getInstance();
        username = b.getStr();

        cau1 = findViewById(R.id.radiogroup4_1);
        cau2 = findViewById(R.id.radiogroup4_2);
        cau3 = findViewById(R.id.radiogroup4_3);
        cau4 = findViewById(R.id.radiogroup4_4);
        cau5 = findViewById(R.id.radiogroup4_5);
        cau1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau4_1A:
                        dem = dem;
                        break;
                    case R.id.cau4_1B:
                        dem++;
                        break;
                    case R.id.cau4_1C:
                        dem= dem;
                        break;
                    case R.id.cau4_1D:
                        dem = dem;
                        break;
                }
            }
        });
        cau2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau4_2A:
                        dem = dem;
                        break;
                    case R.id.cau4_2B:
                        dem++;
                        break;
                    case R.id.cau4_2C:
                        dem = dem;
                        break;
                    case R.id.cau4_2D:
                        dem= dem;
                        break;
                }
            }
        });
        cau3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau4_3A:
                        dem++;
                        break;
                    case R.id.cau4_3B:
                        dem = dem;
                        break;
                    case R.id.cau4_3C:
                        dem = dem;
                        break;
                    case R.id.cau4_3D:
                        dem= dem;
                        break;
                }
            }
        });
        cau4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau4_4A:
                        dem++;
                        break;
                    case R.id.cau4_4B:
                        dem = dem;
                        break;
                    case R.id.cau4_4C:
                        dem = dem;
                        break;
                    case R.id.cau4_4D:
                        dem= dem;
                        break;
                }
            }
        });
        cau5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau4_5A:
                        dem = dem;
                        break;
                    case R.id.cau4_5B:
                        dem = dem;
                        break;
                    case R.id.cau4_5C:
                        dem++;
                        break;
                    case R.id.cau4_5D:
                        dem= dem;
                        break;
                }
            }
        });
        submit = findViewById(R.id.submit4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dem>=4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission4.this);
                    builder.setTitle("Mission Completed");
                    builder.setMessage("You complete the mission 4 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    Date date = new Date();

                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                    DateTime  = df.format(date);
                    ActionName = "Complete Mission 4";
                    HistoryHelpersClass historyHelpersClass = new HistoryHelpersClass(username,ActionName,DateTime);
                    getAuth.push().setValue(historyHelpersClass);

                    onBackPressed();

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission4.this);
                    builder.setTitle("Mission Failed");
                    builder.setMessage("You not complete the mission 4 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    onBackPressed();
                }
            }
        });
    }

}