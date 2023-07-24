package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class CT_AccountActivity extends AppCompatActivity {

    ImageButton btnBack;
    TextView tvCapNhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_account);
        AnhXa();
        onClick();
    }

    private void AnhXa(){
        btnBack = findViewById(R.id.btnBack_CTAccount);
        tvCapNhat = findViewById(R.id.btnCapnhat);
    }

    private void onClick(){
        btnBack.setOnClickListener(v -> {
            finish();
        });
        tvCapNhat.setOnClickListener(v -> {
            Intent i = new Intent(CT_AccountActivity.this,CapNhatThongTinActivity.class);
            startActivity(i);
        });
    }
}