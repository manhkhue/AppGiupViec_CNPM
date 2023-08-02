package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CapNhatThongTinActivity extends AppCompatActivity {

    EditText edtHoTen, edtSoDienThoai, edtDiaChi;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_thong_tin);
        AnhXa();
        onClick();

    }

    private void AnhXa() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        btnSave = findViewById(R.id.btnSave);
    }

    private void onClick() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoTen = edtHoTen.getText().toString();
                String soDienThoai = edtSoDienThoai.getText().toString();
                String diaChi = edtDiaChi.getText().toString();

                SharedPreferences preferences = getSharedPreferences("user_profile", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("hoTen", hoTen);
                editor.putString("soDienThoai", soDienThoai);
                editor.putString("diaChi", diaChi);
                editor.apply();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("hoTen", hoTen);
                resultIntent.putExtra("soDienThoai", soDienThoai);
                resultIntent.putExtra("diaChi", diaChi);
                setResult(RESULT_OK, resultIntent);

                finish();
            }
        });
    }

}
