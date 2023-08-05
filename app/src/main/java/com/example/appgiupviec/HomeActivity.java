package com.example.appgiupviec;

import static com.example.appgiupviec.LoginActivity.isLogin;
import static com.example.appgiupviec.LoginActivity.user;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.BottomNavigation);
        replaceFragment(new HomeFragment());
        onCLick();
        init();
    }

    private void init(){

    }
    private void onCLick (){
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.Home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.Account:
                    replaceFragment(new AccountFragment());
                    break;
                case R.id.ThongBao:
                    replaceFragment(new ThongBaoFragment());
                    break;
                case R.id.Newspaper:
                    replaceFragment(new TinTucFragment());
                    break;

            }
            return true;
        });
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }


}