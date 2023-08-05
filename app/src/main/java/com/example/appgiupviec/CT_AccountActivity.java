package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;

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
                startActivity(i);
            }
        });
    }

    private void loadProfileInfo() {
        tvTenUser.setText(user.getTenUser());
        sdtHoSo.setText(user.getSoDienThoai());
        diaChiHoSo.setText(user.getDiaChi());
    }


}