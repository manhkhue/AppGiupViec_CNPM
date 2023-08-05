package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CapNhatThongTinActivity extends AppCompatActivity {

    EditText edtHoTen, edtDiaChi;
    Button btnSave;
    ImageButton btnBack;

    private static final String url = "https://webdoctruyent5.000webhostapp.com/updateUser.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_thong_tin);
        AnhXa();
        init();
        onClick();

    }

    private void AnhXa() {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBackCapNhat);
    }

    private void init(){
        if(user==null)
        {
            edtHoTen.setText("");
            edtDiaChi.setText("");
        }
        else {
            edtHoTen.setText(user.getTenUser());
            edtDiaChi.setText(user.getDiaChi());
        }

    }
    private void onClick() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_user(user.getMaHK(),edtHoTen.getText().toString(),edtDiaChi.getText().toString());

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void update_user(final String MaKH,final String TenUser, final String DiaChi) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                user.setTenUser(TenUser);
                user.setDiaChi(DiaChi);
                Toast.makeText(CapNhatThongTinActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("MaKH",MaKH);
                map.put("TenKH", TenUser);
                map.put("DiaChi", DiaChi);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

}
