package com.example.badiem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//1D
//2C
//3A
//4C
//5C
public class Mission1 extends AppCompatActivity {

    Button submit;
    RadioGroup cau1,cau2,cau3,cau4,cau5;
    int dem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mission1);

        cau1 = findViewById(R.id.radiogroup1_1);
        cau2 = findViewById(R.id.radiogroup1_2);
        cau3 = findViewById(R.id.radiogroup1_3);
        cau4 = findViewById(R.id.radiogroup1_4);
        cau5 = findViewById(R.id.radiogroup1_5);
        cau1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau1_1A:
                        dem = dem;
                        break;
                    case R.id.cau1_1B:
                        dem = dem;
                        break;
                    case R.id.cau1_1C:
                        dem= dem;
                        break;
                    case R.id.cau1_1D:
                        dem++;
                        break;
                }
            }
        });
        cau2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau1_2A:
                        dem = dem;
                        break;
                    case R.id.cau1_2B:
                        dem = dem;
                        break;
                    case R.id.cau1_2C:
                         dem++;
                        break;
                    case R.id.cau1_2D:
                        dem= dem;
                        break;
                }
            }
        });
        cau3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau1_3A:
                       dem++;
                        break;
                    case R.id.cau1_3B:
                        dem = dem;
                        break;
                    case R.id.cau1_3C:
                        dem = dem;
                        break;
                    case R.id.cau1_3D:
                        dem= dem;
                        break;
                }
            }
        });
        cau4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau1_4A:
                        dem = dem;
                        break;
                    case R.id.cau1_4B:
                        dem = dem;
                        break;
                    case R.id.cau1_4C:
                        dem++;
                        break;
                    case R.id.cau1_4D:
                        dem= dem;
                        break;
                }
            }
        });
        cau5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.cau1_5A:
                        dem = dem;
                        break;
                    case R.id.cau1_5B:
                        dem = dem;
                        break;
                    case R.id.cau1_5C:
                        dem++;
                        break;
                    case R.id.cau1_5D:
                        dem= dem;
                        break;
                }
            }
        });
        submit = findViewById(R.id.submit1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dem>=4) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission1.this);
                    builder.setTitle("Mission Completed");
                    builder.setMessage("You complete the mission 1 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    onBackPressed();

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(Mission1.this);
                    builder.setTitle("Mission Failed");
                    builder.setMessage("You not complete the mission 1 !");
                    builder.setCancelable(false);
                    AlertDialog show = builder.show();
                    onBackPressed();
                }
            }
        });
    }
}