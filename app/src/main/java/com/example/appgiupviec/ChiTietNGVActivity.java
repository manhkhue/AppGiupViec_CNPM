package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChiTietNGVActivity extends AppCompatActivity {
    ImageButton btnBack;
    CircleImageView imgAnh;
    TextView tvTen,tvGioiTinh,tvSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ngvactivity);
        AnhXa();
        init();
        setClick();
    }

    private void AnhXa(){
        btnBack = findViewById(R.id.btnBack_CTNGV);
        imgAnh = findViewById(R.id.civAnh);
        tvTen = findViewById(R.id.tvName);
        tvGioiTinh = findViewById(R.id.tvGioiTinh);
        tvSDT = findViewById(R.id.tvSDT);
    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        tvTen.setText(bundle.getString("TenNGV"));
        tvGioiTinh.setText(bundle.getString("GioiTinh"));
        tvSDT.setText(bundle.getString("SDT"));
        Glide.with(this).load(bundle.getString("HinhAnh")).into(imgAnh);
    }

    private void setClick(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}