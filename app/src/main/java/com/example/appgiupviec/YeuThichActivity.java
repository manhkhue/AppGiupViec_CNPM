package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appgiupviec.Model.NhanVien;
import com.example.appgiupviec.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.DSYeuThichAdapter;

public class YeuThichActivity extends AppCompatActivity {
    public static ArrayList<NhanVien> arrNhanVienYeuThich;
    RecyclerView rcvYeuThich;
    DSYeuThichAdapter YeuThichAdapter;
    ImageButton btnBack;
    private static final String url = "https://webdoctruyent5.000webhostapp.com/layDSYeuThich.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeu_thich);
        init();
        get_DSYeuThich(user.getMaKH());
    }
    private void init(){
        rcvYeuThich = findViewById(R.id.rcvDSYeuThich);
        rcvYeuThich.setLayoutManager(new GridLayoutManager(this,2));
        rcvYeuThich.addItemDecoration(new SpacesItemDecorations(20));
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
//    private void addDSyeuThich(){
//        arrNhanVienYeuThich = new ArrayList<>();
//        arrNhanVienYeuThich.add(new NhanVien("https://vapa.vn/wp-content/uploads/2022/12/anh-3d-thien-nhien-003.jpg","NhanVien1"));
//        arrNhanVienYeuThich.add(new NhanVien("https://noithatbinhminh.com.vn/wp-content/uploads/2022/08/anh-dep-40.jpg","NhanVien2"));
//        arrNhanVienYeuThich.add(new NhanVien("https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045-2.jpg","NhanVien3"));
//        arrNhanVienYeuThich.add(new NhanVien("data:image/jpeg;base64,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","NhanVien4"));
//    }
    public void get_DSYeuThich(final String MaKH) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    try{
                        arrNhanVienYeuThich = new ArrayList<>();
                        arrNhanVienYeuThich.clear();
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            arrNhanVienYeuThich.add(new NhanVien(object));
                        }
                        YeuThichAdapter = new DSYeuThichAdapter(YeuThichActivity.this,arrNhanVienYeuThich);
                        rcvYeuThich.setAdapter(YeuThichAdapter);
                    }
                    catch (JSONException e){
                    }
                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Tải danh sách yêu thích thất bại", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("MaKH",MaKH);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}