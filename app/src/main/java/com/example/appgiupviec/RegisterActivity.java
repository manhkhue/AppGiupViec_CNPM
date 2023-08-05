package com.example.appgiupviec;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText edTenDangKy, edPassDangKy, edNhaclaiMK;
    private Button btnDangKy;
    private static final String url = "https://webdoctruyent5.000webhostapp.com/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AnhXa();
        setClick();
    }

    private void AnhXa(){
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
    }

    private void setClick(){
            btnDangKy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(validateFields())
                    {
                        register_user(edTenDangKy.getText().toString(), edPassDangKy.getText().toString());
                    }
                }
            });
        }
    public void register_user(final String userName, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                if (response.compareTo("Tên đăng nhập đã tồn tại") == 0) {
                    edTenDangKy.setText("");
                    edPassDangKy.setText("");
                    edNhaclaiMK.setText("");
                } else {
                    finishAndRemoveTask();
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("SDT", userName);
                map.put("MatKhau", password);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }

    private boolean validateFields() {
        int yourDesiredLength = 6;
        if (edTenDangKy.getText().length() < yourDesiredLength) {
            edTenDangKy.setError("Tên đăng nhập phải có ít nhất 6 ký tự");
            return false;
        } else if (edPassDangKy.getText().length() < yourDesiredLength) {
            edPassDangKy.setError("Mật khẩu phải có ít nhất 6 kí tự");
            return false;
        } else if(!edNhaclaiMK.getText().toString().equalsIgnoreCase(edNhaclaiMK.getText().toString())){
            edNhaclaiMK.setError("Xác nhận mật khẩu của bạn không đúng! Xin vui lòng nhập lại");
            return false;
        }
        return true;
    }
}
