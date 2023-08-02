package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.appgiupviec.R;

import java.util.Calendar;

public class DatApp1Activity extends AppCompatActivity {

    private ImageView imgBack;
    private Button buttonTiepTuc;
    private Button Day;
    private Button Hours;
    private EditText ghiChu11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app1);
        AnhXa();
        setClick();



    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = String.format("%d/%d/%d", dayOfMonth, month + 1, year);
                Day.setText(selectedDate);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String selectedTime = String.format("%02d:%02d", hourOfDay, minute);
                Hours.setText(selectedTime);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    private void Init(){

    }

    private void AnhXa(){
        imgBack = findViewById(R.id.img_BackDH);
        buttonTiepTuc = findViewById(R.id.buttontieptuc1);
        Day = findViewById(R.id.Day);
        Hours = findViewById(R.id.Hours);
        ghiChu11 = findViewById(R.id.GhiChu11);
    }

    private void setClick(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        Hours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

        buttonTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getBundleExtra("data");
                String tenDichVu = bundle.getString("tenDichVu");
                String thoiluong = bundle.getString("ThoiLuong");
                String selectedNgay = Day.getText().toString();
                String selectedGio = Hours.getText().toString();
                String ghiChu = ghiChu11.getText().toString();
                startDatApp2Activity(tenDichVu,thoiluong, selectedNgay, selectedGio, ghiChu);

            }


            private void startDatApp2Activity(String tenDichVu,String thoiLuong, String ngayLamViec, String gioLamViec, String ghiChu) {
                Bundle bundle = new Bundle();
                bundle.putString("TenDichVu",tenDichVu);
                bundle.putString("ThoiLuong",thoiLuong);
                bundle.putString("NgayLamViec",ngayLamViec);
                bundle.putString("GioLamViec",gioLamViec);
                bundle.putString("GhiChu",ghiChu);
                Intent intent = new Intent(DatApp1Activity.this, DatApp2Activity.class);
//
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
    }
}
