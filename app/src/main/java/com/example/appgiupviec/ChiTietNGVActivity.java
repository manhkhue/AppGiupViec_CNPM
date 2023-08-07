package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;
import static com.example.appgiupviec.YeuThichActivity.arrNhanVienYeuThich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.appgiupviec.Model.NhanVien;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChiTietNGVActivity extends AppCompatActivity {
    ImageButton btnBack,btnLike;
    CircleImageView imgAnh;
    TextView tvTen,tvGioiTinh,tvSDT;
    private static final String url = "https://webdoctruyent5.000webhostapp.com/ThemVaoDSYeuThich.php";
    private static final String url1 ="https://webdoctruyent5.000webhostapp.com/XoaKhoiDSYeuThich.php";
    boolean clicked;
    String MaNGV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_ngvactivity);
        AnhXa();
        init();
        setClick();
    }

    private void AnhXa(){
        btnBack = findViewById(R.id.btnBack_CTNGV);
        imgAnh = findViewById(R.id.civAnh);
        tvTen = findViewById(R.id.tvName);
        tvGioiTinh = findViewById(R.id.tvGioiTinh);
        tvSDT = findViewById(R.id.tvSDT);
        btnLike = findViewById(R.id.btnLike);
    }
    private void init(){
        Bundle bundle = getIntent().getBundleExtra("data");
        tvTen.setText(bundle.getString("TenNGV"));
        tvGioiTinh.setText(bundle.getString("GioiTinh"));
        tvSDT.setText(bundle.getString("SDT"));
        Glide.with(this).load(bundle.getString("HinhAnh")).into(imgAnh);
        MaNGV = bundle.getString("MaNGV");
        if(arrNhanVienYeuThich!=null){
            for (int i=0;i<arrNhanVienYeuThich.size();i++){
                NhanVien nhanVien = arrNhanVienYeuThich.get(i);
                if(MaNGV.compareTo(nhanVien.getMaNGV())==0){
                    clicked = true;
                }
                else {
                    clicked = false;
                }
            }
        }

        btnLike.setTag(clicked);
        if((boolean)btnLike.getTag()==true){
            btnLike.setImageResource(R.drawable.baseline_favorite_24);
        }
    }

    private void setClick(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ((boolean) btnLike.getTag()) == false) {
                    btnLike.setImageResource(R.drawable.baseline_favorite_24);
                    add_YeuThich(user.getMaKH(),MaNGV);
                    Toast.makeText(ChiTietNGVActivity.this, "Thêm vào danh sách yêu thích thành công", Toast.LENGTH_SHORT).show();
                    btnLike.setTag(true);
                }
                else if((boolean)btnLike.getTag()){
                    btnLike.setImageResource(R.drawable.baseline_favorite_border_24);
                    Remove_YeuThich(user.getMaKH(),MaNGV);
                    Toast.makeText(ChiTietNGVActivity.this, "Xóa khỏi danh sách yêu thích thành công", Toast.LENGTH_SHORT).show();
                    btnLike.setTag(false);
                }
            }
        });
    }
    public void add_YeuThich(final String MaKH,final String MaNGV) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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
                map.put("MaNGV",MaNGV);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
    public void Remove_YeuThich(final String MaKH,final String MaNGV) {
        StringRequest request = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

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
                map.put("MaNGV",MaNGV);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}