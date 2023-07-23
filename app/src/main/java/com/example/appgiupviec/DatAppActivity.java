package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.appgiupviec.Model.ThoiLuong;

import java.util.ArrayList;

import Adapter.ThoiLuongAdapter;

public class DatAppActivity extends AppCompatActivity {

    private ImageView imgBack;
    private RecyclerView recyclerView;
    private ArrayList<ThoiLuong> thoiLuongList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app);

        imgBack = findViewById(R.id.img_quaylai);
        recyclerView = findViewById(R.id.DienTich);


        thoiLuongList = new ArrayList<>();
        thoiLuongList.add(new ThoiLuong("Thời lượng 3"));
        thoiLuongList.add(new ThoiLuong("Thời lượng 2"));
        thoiLuongList.add(new ThoiLuong("Thời lượng 3"));
        thoiLuongList.add(new ThoiLuong("Thời lượng 4"));

        ThoiLuongAdapter adapter = new ThoiLuongAdapter(thoiLuongList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

}