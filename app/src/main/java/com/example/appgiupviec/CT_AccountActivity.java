package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;

public class CT_AccountActivity extends AppCompatActivity {

    ImageButton btnBack;
    TextView tvCapNhat, tvTenUser, sdtHoSo, diaChiHoSo;

    private static final int CAP_NHAT_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_account);
        AnhXa();
        onClick();
        loadProfileInfo();
    }

    private void AnhXa(){
        btnBack = findViewById(R.id.btnBack_CTAccount);
        tvCapNhat = findViewById(R.id.btnCapnhat);
        tvTenUser = findViewById(R.id.tvTenUser);
        sdtHoSo = findViewById(R.id.sdtHoSo);
        diaChiHoSo = findViewById(R.id.diaChiHoSo);
    }

    private void onClick(){
        btnBack.setOnClickListener(v -> {
            finish();
        });
        tvCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CT_AccountActivity.this, CapNhatThongTinActivity.class);
                startActivityForResult(i, CAP_NHAT_REQUEST_CODE);
            }
        });
    }

    private void loadProfileInfo() {
        SharedPreferences preferences = getSharedPreferences("user_profile", MODE_PRIVATE);
        String hoTen = preferences.getString("hoTen", "");
        String soDienThoai = preferences.getString("soDienThoai", "");
        String diaChi = preferences.getString("diaChi", "");

        tvTenUser.setText(hoTen);
        sdtHoSo.setText(soDienThoai);
        diaChiHoSo.setText(diaChi);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAP_NHAT_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String hoTen = data.getStringExtra("hoTen");
            String soDienThoai = data.getStringExtra("soDienThoai");
            String diaChi = data.getStringExtra("diaChi");

            tvTenUser.setText(hoTen);
            sdtHoSo.setText(soDienThoai);
            diaChiHoSo.setText(diaChi);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("hoTen", hoTen);
            resultIntent.putExtra("soDienThoai", soDienThoai);
            resultIntent.putExtra("diaChi", diaChi);

            setResult(RESULT_OK, resultIntent);

            finish();
        }
    }

}