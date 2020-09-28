package com.example.dhts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name,email,phone;
    TextView date1;
    DatePickerDialog.OnDateSetListener setListener;
    ImageButton button,btn;

    DatabaseReference ref;
    Details details;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.number);
        date1 = findViewById(R.id.date);

        details = new Details();


        Toast.makeText(getApplicationContext(),"Configuration successfully!",Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.ib1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref = FirebaseDatabase.getInstance().getReference().child("Member");

                details.setName(name.getText().toString().trim());
                details.setEmail(email.getText().toString().trim());
                details.setPhone(phone.getText().toString().trim());
                details.setDate(date1.getText().toString().trim());

                ref.child("Mb").setValue(details);

                String data1 = name.getText().toString().trim();
                String data2 = email.getText().toString().trim();
                String data3 = phone.getText().toString().trim();
                String data4 = date1.getText().toString().trim();

                Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),loginDetails.class);

                i.putExtra("nm",data1);
                i.putExtra("em",data2);
                i.putExtra("ph",data3);
                i.putExtra("dt",data4);

                startActivity(i);
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_LONG).show();
            }
        });




        date1 = findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1+1;
                String date = day+" - "+i1+" - "+i;
                date1.setText(date);
            }
        };



    }
}