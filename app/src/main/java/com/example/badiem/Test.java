package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test extends AppCompatActivity {

    EditText txt, txtpss;
    TextView txtv, txtpssv;
    Button btnResult;

    String txtText, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Hash cr = new Hash();
        binding();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText(cr.getSHA512(txt.getText().toString()));
                txtpssv.setText(cr.getSHA512(txtpss.getText().toString()));

                System.out.println("text: " + cr.getSHA512(txt.getText().toString()));
                System.out.println("textPass: " + cr.getSHA512(txtpss.getText().toString()));
            }
        });

    }


    private void binding() {
        txt = findViewById(R.id.txtPlaint);
        txtpss = findViewById(R.id.txtTextPass);
        txtv = findViewById(R.id.txtResult);
        txtpssv = findViewById(R.id.txtTextPassResult);
        btnResult = findViewById(R.id.btnResult);
    }
}
