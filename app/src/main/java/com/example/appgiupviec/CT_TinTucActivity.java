package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CT_TinTucActivity extends AppCompatActivity {
    TextView tvTieuDe,tvNoiDung;
    ImageButton btnback;
    ImageView ivHinhAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_tin_tuc);
        AnhXa();
        init();
        setClick();
    }
    private void AnhXa(){
        tvTieuDe = findViewById(R.id.TieuDe);
        tvNoiDung = findViewById(R.id.NoiDung);
        btnback = findViewById(R.id.buttonBack);
        ivHinhAnh = findViewById(R.id.HinhAnh);
    }
    private void init(){
        Bundle bundle=getIntent().getBundleExtra("data");
        tvTieuDe.setText(bundle.getString("TieuDe"));
        tvNoiDung.setText(bundle.getString("NoiDung"));
        Glide.with(this).load(bundle.getString("linkAnh")).into(ivHinhAnh);
    }
    private void setClick(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}