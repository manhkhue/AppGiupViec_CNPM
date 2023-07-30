package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DatApp2Activity extends AppCompatActivity {

    private ImageView imgBack;
    private Button btnDangViec;
    private TextView tvThoiLuongValue, tvNgayLamViecValue, tvGioLamViecValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app2);
        imgBack = findViewById(R.id.img_BackDH2);
        btnDangViec = findViewById(R.id.btnDangViec);

        tvThoiLuongValue = findViewById(R.id.tvThoiLuongValue);
        tvNgayLamViecValue = findViewById(R.id.tvNgayLamViecValue);
        tvGioLamViecValue = findViewById(R.id.tvGioLamViecValue);
        TextView tvGhiChuValue = findViewById(R.id.tvGhiChuValue);


        Intent intent = getIntent();
        String selectedThoiLuong = intent.getStringExtra("THOI_LUONG_CONG_VIEC");
        String ngayLamViec = intent.getStringExtra("NGAY_DA_CHON");
        String gioLamViec = intent.getStringExtra("GIO_DA_CHON");
        String ghiChu = intent.getStringExtra("GHI_CHU");


        tvThoiLuongValue.setText(selectedThoiLuong);
        tvNgayLamViecValue.setText(ngayLamViec);
        tvGioLamViecValue.setText(gioLamViec);
        tvGhiChuValue.setText(ghiChu);

        btnDangViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(DatApp2Activity.this, "Đăng việc thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DatApp2Activity.this, HomeActivity.class);
                startActivity(intent);
                finish();
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
