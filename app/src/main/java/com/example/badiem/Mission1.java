package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;

//1D
//2C
//3A
//4C
//5C
public class Mission1 extends AppCompatActivity {

    RadioButton cau1A,cau1B,cau1C,cau1D,cau2A,cau2B,cau2C,cau2D
            ,cau3A,cau3B,cau3C,cau3D,cau4A,cau4B,cau4C,cau4D,
            cau5A,cau5B,cau5C,cau5D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission1);
        cau1A = findViewById(R.id.dapan1);
        cau1B = findViewById(R.id.dapan2);
        cau1C = findViewById(R.id.dapan3);
        cau1D = findViewById(R.id.dapan4);

        cau2A = findViewById(R.id.cau2A);
        cau2B = findViewById(R.id.cau2B);
        cau2C = findViewById(R.id.cau2C);
        cau2D = findViewById(R.id.cau2D);

        cau3A = findViewById(R.id.cau3A);
        cau3B = findViewById(R.id.cau3B);
        cau3C = findViewById(R.id.cau3C);
        cau3D = findViewById(R.id.cau3D);

        cau4A = findViewById(R.id.cau4A);
        cau4B = findViewById(R.id.cau4B);
        cau4C = findViewById(R.id.cau4C);
        cau4D = findViewById(R.id.cau4D);

        cau5A = findViewById(R.id.cau5A);
        cau5B = findViewById(R.id.cau5B);
        cau5C = findViewById(R.id.cau5C);
        cau5D = findViewById(R.id.cau5D);


    }
}