package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CT_ThongBaoActivity extends AppCompatActivity {
    ImageView ivHinhAnh;
    ImageButton btnBack;
    TextView tvTieuDe,tvNoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_thong_bao);
        AnhXa();
        init();
        setClick();
    }
    private void AnhXa(){
        tvTieuDe = findViewById(R.id.TieuDeUuDai);
        tvNoiDung = findViewById(R.id.NoiDungUuDai);
        btnBack = findViewById(R.id.btnBack_UuDai);
        ivHinhAnh = findViewById(R.id.imgAnhUuDai);
    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        tvTieuDe.setText(bundle.getString("TieuDe"));
        tvNoiDung.setText(bundle.getString("NoiDung"));
        Glide.with(this).load(bundle.getString("linkAnh")).into(ivHinhAnh);
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