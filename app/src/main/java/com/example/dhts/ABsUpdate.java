package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ABsUpdate extends AppCompatActivity {

    EditText time,date,note;
    DatabaseReference dbref;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_bs_update);

        time = findViewById(R.id.Name9);
        date = findViewById(R.id.Name11);
        note = findViewById(R.id.Name10);

        String nn = getIntent().getStringExtra("da");
        String nm = getIntent().getStringExtra("db");
        String nu = getIntent().getStringExtra("dc");

        time.setText(nn);
        date.setText(nm);
        note.setText(nu);

        bt=findViewById(R.id.buttonsub2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i7);

                String nn = time.getText().toString();
                String nm = date.getText().toString();
                String nu = note.getText().toString();


                dbref = FirebaseDatabase.getInstance().getReference().child("AddData2");

                HashMap hashMap = new HashMap();

                hashMap.put("dateAdd",nn);
                hashMap.put("timeAdd",nm);
                hashMap.put("noteAdd",nu);

                dbref.child("abs").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });




    }
}