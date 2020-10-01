package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class addpikepushupi extends AppCompatActivity {
    Button addingbut;
    DatabaseReference db;

    Adding add;
    EditText additional1,additional2,additional3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpikepushupi);

        add = new Adding();


        addingbut = findViewById(R.id.adb);
        additional1 = findViewById(R.id.addi1);
        additional2 = findViewById(R.id.addi2);
        additional3 = findViewById(R.id.addi3);

        addingbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add.setAddi1(additional1.getText().toString().trim());
                add.setAddi2(additional2.getText().toString().trim());
                add.setAddi3(additional3.getText().toString().trim());


                db= FirebaseDatabase.getInstance().getReference().child("pikepushup");


                db.child("Additional info").setValue(add);




                String data1 = additional1.getText().toString();
                String data2 = additional2.getText().toString();
                String data3 = additional3.getText().toString();





                Intent i3  = new Intent(getApplicationContext(),pikepushup.class);

                i3.putExtra("f0", data1);
                i3.putExtra("f1",data2);
                i3.putExtra("f2",data3);




                startActivity(i3);



            }
        });
    }
}