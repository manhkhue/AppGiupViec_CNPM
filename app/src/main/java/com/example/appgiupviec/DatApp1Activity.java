package com.example.appgiupviec;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class DatApp1Activity extends AppCompatActivity {

    private ImageView imgBack;
    private Button buttonTiepTuc;

    private Button Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_app1);

        imgBack = findViewById(R.id.img_BackDH);
        buttonTiepTuc = findViewById(R.id.buttontieptuc1);
        Day = findViewById(R.id.Day);



        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        buttonTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DatApp1Activity.this, DatApp2Activity.class);
                startActivity(intent);

            }
        });
    }
    public void Day(View view){
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                Toast.makeText(DatApp1Activity.this, String.format("Selected Date: %d/%d/%d", day, month, year), Toast.LENGTH_SHORT).show();

            }
        },year, month, year );
        datePickerDialog.show();

    }


}