package com.example.appgiupviec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appgiupviec.Model.User;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edSdtLogin, edPassLogin;
    private Button btnLogin;
    private TextView tvDkiDn, tvQuenMK;


    static Boolean isLogin = false;
    public static User user;
    private static final String url = "https://webdoctruyent5.000webhostapp.com/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        setClick();

    }

    private void AnhXa(){
        edSdtLogin = findViewById(R.id.ed_sdt_login);
        edPassLogin = findViewById(R.id.ed_pass_login);
        btnLogin = findViewById(R.id.btn_login);
        tvDkiDn = findViewById(R.id.tv_dki_DN);
        tvQuenMK = findViewById(R.id.tv_quenMK_DN);
    }

    private void setClick(){
        tvDkiDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        tvQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edSdtLogin.getText().toString().trim();
                String password = edPassLogin.getText().toString().trim();

                if (TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập đầy đủ thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                } else {
                    login_user(phoneNumber, password);
                }
            }
        });
    }
    public void login_user(final String phoneNumber, final String password) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.compareTo("[]\n\n")==0){
                    Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        JSONArray jsonArray = new JSONArray(response);
                        JSONObject object = jsonArray.getJSONObject(0);
                        user = new User(object);
                    }
                    catch (JSONException e){
                    }
                    isLogin = true;
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("islogin",isLogin);
                    bundle.putString("TenUser",user.getTenUser());
                    intent.putExtra("status",bundle);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("SDT", phoneNumber);
                map.put("MatKhau", password);
                return map;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}
