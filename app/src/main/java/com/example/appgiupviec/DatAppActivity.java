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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app);

        imgBack = findViewById(R.id.img_quaylai);
        recyclerViewDienTich = findViewById(R.id.recyclerViewDienTich);

        thoiLuongList = new ArrayList<>();
        thoiLuongList.add(new ThoiLuong("1 giờ: 1 phòng(30m2)"));
        thoiLuongList.add(new ThoiLuong("2 giờ: 2 phòng(50m2)"));
        thoiLuongList.add(new ThoiLuong("3 giờ: 3 phòng(70m2)"));

        ThoiLuongAdapter adapter = new ThoiLuongAdapter(thoiLuongList, new ThoiLuongAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ThoiLuong thoiLuong) {
                selectedThoiLuong = thoiLuong.getThoiLuong();
            }
        });

        recyclerViewDienTich.setAdapter(adapter);
        recyclerViewDienTich.setLayoutManager(new LinearLayoutManager(this));

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
                    intent.putExtra("THOI_LUONG_CONG_VIEC", selectedThoiLuong);
                    startActivity(intent);
                } else {
                    Toast.makeText(DatAppActivity.this, "Vui lòng chọn thời lượng trước khi tiếp tục", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
