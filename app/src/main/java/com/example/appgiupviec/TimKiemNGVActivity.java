package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appgiupviec.Model.NhanVien;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Adapter.NhanVienAdapter;
import api.ApiGetDSNguoiGiupViec;
import interfaces.getDSNguoiGiupViecFromApi;

public class TimKiemNGVActivity extends AppCompatActivity implements getDSNguoiGiupViecFromApi {

    ArrayList<NhanVien> arrNGV;
    NhanVienAdapter adapter;
    RecyclerView rcvDSNGV;
    String tenNGV = "";
    EditText edtTimKiem;
    Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem_ngvactivity);
        AnhXa();
        init();
        setClick();
        new ApiGetDSNguoiGiupViec(this,tenNGV).execute();
    }

    private void AnhXa(){
        rcvDSNGV = findViewById(R.id.rcvDSNhanVien);
        edtTimKiem = findViewById(R.id.edtTimKiem);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private void init(){

        arrNGV = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvDSNGV.setLayoutManager(linearLayoutManager);
        adapter = new NhanVienAdapter(this,arrNGV);
        rcvDSNGV.setAdapter(adapter);
    }

    private void setClick(){
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edtTimKiem.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    tenNGV=edtTimKiem.getText().toString();

                    new ApiGetDSNguoiGiupViec(TimKiemNGVActivity.this,tenNGV).execute();
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void Start() {
    }

    @Override
    public void End(String data) {
        try {
            arrNGV.clear();
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                arrNGV.add(new NhanVien(object));
            }
            adapter = new NhanVienAdapter(this,arrNGV);
            rcvDSNGV.setAdapter(adapter);
        } catch (JSONException e) {
        }
    }

    @Override
    public void Error() {

    }
}