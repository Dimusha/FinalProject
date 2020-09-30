package com.example.dhts;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class loginDetails extends AppCompatActivity {

    TextView name,email,phone,nic;
    DatabaseReference ref;
    ImageButton btn,btn1,btn2;

    public void clear(){
        name.setText("");
        email.setText("");
        phone.setText("");
        nic.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        final String s1=getIntent().getStringExtra("key");


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
                i.putExtra("key",s1);

                i.putExtra("nm",data1);
                i.putExtra("em",data2);
                i.putExtra("ph",data3);
                i.putExtra("nc",data4);

                startActivity(i);

            }
        });

        btn1= findViewById(R.id.delete);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dlRef = FirebaseDatabase.getInstance().getReference().child("Member");
                dlRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(s1)){
                            ref =FirebaseDatabase.getInstance().getReference().child("Member").child(s1);
                            ref.removeValue();
                            clear();
                            Toast.makeText(getApplicationContext(),"Deleted successfully!",Toast.LENGTH_LONG).show();


                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No source to delete!",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        btn2 = findViewById(R.id.ib3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CARD_DETAILS.class);
                startActivity(i);
            }
        });
    }
}