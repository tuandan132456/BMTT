package com.example.badiem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;

//1B
//2C
//3A
//4C
//5A
public class Mission3 extends AppCompatActivity {

    Button submit;
    RadioGroup cau1,cau2,cau3,cau4,cau5;
    int dem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mission3);

        cau1 = findViewById(R.id.radiogroup3_1);
        cau2 = findViewById(R.id.radiogroup3_2);
        cau3 = findViewById(R.id.radiogroup3_3);
        cau4 = findViewById(R.id.radiogroup3_4);
        cau5 = findViewById(R.id.radiogroup3_5);
        cau1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau3_1A:
                        dem = dem;
                        break;
                    case R.id.cau3_1B:
                        dem++;
                        break;
                    case R.id.cau3_1C:
                        dem= dem;
                        break;
                    case R.id.cau3_1D:
                        dem = dem;
                        break;
                }
            }
        });
        cau2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau3_2A:
                        dem = dem;
                        break;
                    case R.id.cau3_2B:
                        dem = dem;
                        break;
                    case R.id.cau3_2C:
                        dem++;
                        break;
                    case R.id.cau3_2D:
                        dem= dem;
                        break;
                }
            }
        });
        cau3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau3_3A:
                        dem++;
                        break;
                    case R.id.cau3_3B:
                        dem = dem;
                        break;
                    case R.id.cau3_3C:
                        dem = dem;
                        break;
                    case R.id.cau3_3D:
                        dem= dem;
                        break;
                }
            }
        });
        cau4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau3_4A:
                        dem = dem;
                        break;
                    case R.id.cau3_4B:
                        dem = dem;
                        break;
                    case R.id.cau3_4C:
                        dem++;
                        break;
                    case R.id.cau3_4D:
                        dem= dem;
                        break;
                }
            }
        });
        cau5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau3_5A:
                        dem++;
                        break;
                    case R.id.cau3_5B:
                        dem = dem;
                        break;
                    case R.id.cau3_5C:
                        dem = dem;
                        break;
                    case R.id.cau3_5D:
                        dem= dem;
                        break;
                }
            }
        });
        submit = findViewById(R.id.submit3);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dem>=4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission3.this);
                    builder.setTitle("Mission Completed");
                    builder.setMessage("You complete the mission 3 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    onBackPressed();

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission3.this);
                    builder.setTitle("Mission Failed");
                    builder.setMessage("You not complete the mission 3 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    onBackPressed();
                }
            }
        });
    }
}