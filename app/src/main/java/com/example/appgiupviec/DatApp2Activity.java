package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DatApp2Activity extends AppCompatActivity {

    private ImageView imgBack;
    private Button btnDangViec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app2);
        imgBack = findViewById(R.id.img_BackDH2);
        btnDangViec = findViewById(R.id.btnDangViec);

        btnDangViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}