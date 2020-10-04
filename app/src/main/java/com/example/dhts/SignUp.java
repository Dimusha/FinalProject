package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText te1, te2, te3, te4, te5;
    Button btn1;
    DatabaseReference dbref;
    Add1 add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        te1 = findViewById(R.id.t1);
        te2 = findViewById(R.id.t2);
        te3 = findViewById(R.id.t3);
        te4 = findViewById(R.id.t4);
        te5 = findViewById(R.id.t5);

        btn1 = findViewById(R.id.button2);

        add = new Add1();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbref = FirebaseDatabase.getInstance().getReference().child("SignUpDetails");

                add.setText1(te1.getText().toString().trim());
                add.setText2(te2.getText().toString().trim());
                add.setText2(te3.getText().toString().trim());
                add.setText2(te4.getText().toString().trim());
                add.setText2(te5.getText().toString().trim());


                dbref.child("signup").setValue(add);

                String detail1 =  te1.getText().toString();
                String detail2 = te2.getText().toString();
                String detail3 =  te3.getText().toString();
                String detail4 = te4.getText().toString();
                String detail5 =  te5.getText().toString();

                Intent i = new Intent(getApplicationContext(),home.class);
                startActivity(i);




            }
        });

    }
}