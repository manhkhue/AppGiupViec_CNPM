package com.example.appgiupviec;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText edTenDangKy, edPassDangKy, edNhaclaiMK;
    private Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edTenDangKy = findViewById(R.id.ed_tenDN_dangky);
        edPassDangKy = findViewById(R.id.ed_pass_dangky);
        edNhaclaiMK = findViewById(R.id.ed_nhaclaiMK);
        btnDangKy = findViewById(R.id.btn_dangky);

        Toolbar toolbar = findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edTenDangKy.getText().toString().trim();
                String password = edPassDangKy.getText().toString().trim();
                String confirmPassword = edNhaclaiMK.getText().toString().trim();

                if (TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin đăng ký", Toast.LENGTH_SHORT).show();
                } else {

                    if (password.equals(confirmPassword)) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Xác nhận mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
