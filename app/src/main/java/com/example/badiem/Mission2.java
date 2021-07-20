package com.example.badiem;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

//Qatar
//Nhật Bản
//Đỗ Nhuận
//Quảng Trị
//Cầu Sông Hàn
public class Mission2 extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup2_1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.cau2_1A:
                        Toast.makeText(Mission2.this, "Bạn chọn A", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cau2_1B:
                        Toast.makeText(Mission2.this, "Bạn chọn B", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cau2_1C:
                        Toast.makeText(Mission2.this, "Bạn chọn C", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cau2_1D:
                        Toast.makeText(Mission2.this, "Bạn chọn D", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}