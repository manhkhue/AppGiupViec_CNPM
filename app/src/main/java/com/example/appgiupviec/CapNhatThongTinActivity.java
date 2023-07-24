package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

public class CapNhatThongTinActivity extends AppCompatActivity {

    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_thong_tin);
        AnhXa();
        onClick();
    }

    private void AnhXa(){
        btnBack = findViewById(R.id.btnBackCapNhat);
    }
    private void onClick(){
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }

}