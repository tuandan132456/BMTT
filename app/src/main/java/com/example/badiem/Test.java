package com.example.badiem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_test);
        EncryptAndHash cr = new EncryptAndHash();
        binding();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtv.setText(cr.Encrypter(txt.getText().toString()));
                txtpssv.setText(cr.Encrypter(txtpss.getText().toString()));

                System.out.println("text: " + cr.Encrypter(txt.getText().toString()));
                System.out.println("textPass: " + cr.Encrypter(txtpss.getText().toString()));
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
