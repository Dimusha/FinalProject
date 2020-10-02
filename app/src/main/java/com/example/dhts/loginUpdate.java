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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class loginUpdate extends AppCompatActivity {

    EditText nm,em,ph,nc;
   ImageButton btn;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_update);

        final String s1=getIntent().getStringExtra("key");

        nm = findViewById(R.id.name);
        em = findViewById(R.id.email);
        ph = findViewById(R.id.pNumber);
        nc = findViewById(R.id.nic);

        String name = getIntent().getStringExtra("nm");
        String email = getIntent().getStringExtra("em");
        String phone = getIntent().getStringExtra("ph");
        String nic = getIntent().getStringExtra("nc");

        nm.setText(name);
        em.setText(email);
        ph.setText(phone);
        nc.setText(nic);

        btn = findViewById(R.id.ib3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nm.getText().toString();
                String email = em.getText().toString();
                String contact = ph.getText().toString();
                String nic = nc.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("Member");

                HashMap hashMap = new HashMap();

                hashMap.put("name", name);
                hashMap.put("email", email);
                hashMap.put("phone", contact);
                hashMap.put("nic", nic);

                ref.child(s1).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(), "Successfully updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), CARD_DETAILS.class);
                        startActivity(i);
                    }
                });


            }

        });
    }
}