package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appgiupviec.Model.ThoiLuong;

import java.util.ArrayList;

import Adapter.ThoiLuongAdapter;

public class DatAppActivity extends AppCompatActivity {

    private ImageView imgBack;
    private RecyclerView recyclerViewDienTich;
    private ArrayList<ThoiLuong> thoiLuongList;
    private String selectedThoiLuong;
    private String tenDichVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app);
        AnhXa();
        init();
        setClick();
        setUP();

    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        int DonGia = bundle.getInt("GiaCa");
        tenDichVu = bundle.getString("TenDichVu");
        thoiLuongList = new ArrayList<>();
        thoiLuongList.add(new ThoiLuong("1 giờ: 1 phòng(30m2)",DonGia*1 + " VND"));
        thoiLuongList.add(new ThoiLuong("2 giờ: 2 phòng(50m2)",DonGia*2 + " VND"));
        thoiLuongList.add(new ThoiLuong("3 giờ: 3 phòng(70m2)",DonGia*3 + " VND"));
    }

    private void AnhXa(){
        imgBack = findViewById(R.id.img_quaylai);
        recyclerViewDienTich = findViewById(R.id.recyclerViewDienTich);
    }

    private void setUP(){
        ThoiLuongAdapter adapter = new ThoiLuongAdapter(thoiLuongList, new ThoiLuongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ThoiLuong thoiLuong) {
                selectedThoiLuong = thoiLuong.getThoiLuong();
            }
        });
        recyclerViewDienTich.setAdapter(adapter);
        recyclerViewDienTich.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setClick(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        findViewById(R.id.buttontieptuc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedThoiLuong != null) {
                    Intent intent = new Intent(DatAppActivity.this, DatApp1Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("ThoiLuong",selectedThoiLuong);
                    bundle.putString("tenDichVu",tenDichVu);
                    intent.putExtra("data", bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(DatAppActivity.this, "Vui lòng chọn thời lượng trước khi tiếp tục", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
