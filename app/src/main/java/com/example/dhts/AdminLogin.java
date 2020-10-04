package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminLogin extends AppCompatActivity {

    Button btn1;
    DatabaseReference dbref;

    EditText text1, text2;
    Add da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        text1 = findViewById(R.id.te1);
        text2 = findViewById(R.id.te2);

        btn1 = findViewById(R.id.button);
        da = new Add();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbref = FirebaseDatabase.getInstance().getReference().child("AdminLoginDetails");

                da.setText1(text1.getText().toString().trim());
                da.setText2(text2.getText().toString().trim());

                dbref.child("login").setValue(da);

                String detail1 =  text1.getText().toString();
                String detail2 = text2.getText().toString();

                Intent i = new Intent(getApplicationContext(),home.class);
                startActivity(i);



            }
        });
    }
}