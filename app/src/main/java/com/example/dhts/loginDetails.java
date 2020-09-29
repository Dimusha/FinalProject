package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class loginDetails extends AppCompatActivity {

    TextView name,email,phone,nic;
    //DatePickerDialog.OnDateSetListener setListener;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.ph);
        nic = findViewById(R.id.nic);

        String nm = getIntent().getStringExtra("nm");
        String em = getIntent().getStringExtra("em");
        String ph = getIntent().getStringExtra("ph");
        String nc = getIntent().getStringExtra("nc");

        name.setText(nm);
        email.setText(em);
        phone.setText(ph);
        nic.setText(nc);

        btn = findViewById(R.id.update);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = name.getText().toString().trim();
                String data2 = email.getText().toString().trim();
                String data3 = phone.getText().toString().trim();
                String data4 = nic.getText().toString().trim();

                Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),loginUpdate.class);

                i.putExtra("nm",data1);
                i.putExtra("em",data2);
                i.putExtra("ph",data3);
                i.putExtra("nc",data4);

                startActivity(i);

            }
        });

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        /*dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        loginDetails.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                String date = day+" - "+i1+" - "+i;
                dat.setText(date);
            }
        };*/
    }
}