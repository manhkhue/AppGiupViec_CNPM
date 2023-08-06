package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;

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
    private TextView tvThoiLuongValue, tvNgayLamViecValue, tvGioLamViecValue, tvGhiChuValue, tvTenDichVu, tvDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app2);
        imgBack = findViewById(R.id.img_BackDH2);
        btnDangViec = findViewById(R.id.btnDangViec);
        tvThoiLuongValue = findViewById(R.id.tvThoiLuongTitle);
        tvNgayLamViecValue = findViewById(R.id.tvNgayLamViecTitle);
        tvGioLamViecValue = findViewById(R.id.tvGioLamViecTitle);
        tvGhiChuValue = findViewById(R.id.tvGhiChuTitle);
        tvTenDichVu = findViewById(R.id.tvTenCongViec);
        tvDiaChi = findViewById(R.id.tvDiaChiTitle);
        Bundle bundle = getIntent().getBundleExtra("data");
        String tenDichVu = bundle.getString("TenDichVu");
        String selectedThoiLuong = bundle.getString("ThoiLuong");
        String ngayLamViec = bundle.getString("NgayLamViec");
        String gioLamViec = bundle.getString("GioLamViec");
        String ghiChu = bundle.getString("GhiChu");

        tvTenDichVu.setText("Tên công việc: "+tenDichVu);
        tvThoiLuongValue.setText("Thời lượng: "+selectedThoiLuong);
        tvNgayLamViecValue.setText("Ngày làm việc: "+ngayLamViec);
        tvGioLamViecValue.setText("Giờ làm việc: "+gioLamViec);
        tvGhiChuValue.setText("Ghi chú: "+ ghiChu);
        tvDiaChi.setText("Địa chỉ: "+user.getDiaChi());

        btnDangViec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatApp2Activity.this, "Đăng việc thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DatApp2Activity.this, HomeActivity.class);
                startActivity(intent);
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
