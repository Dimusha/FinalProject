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

public class updateExercise3 extends AppCompatActivity {

    EditText ch1,ch2,ch3,ch4,le1,le2,le3,le4,sh1,sh2,sh3,sh4,ar1,ar2,ar3,ar4;
    Button btn;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_exercise3);

        ch1 = findViewById(R.id.c1);
        ch2 = findViewById(R.id.c2);
        ch3 = findViewById(R.id.c3);
        ch4 = findViewById(R.id.c4);

        le1 = findViewById(R.id.l1);
        le2 = findViewById(R.id.l2);
        le3 = findViewById(R.id.l3);
        le4 = findViewById(R.id.l4);

        sh1 = findViewById(R.id.s1);
        sh2 = findViewById(R.id.s2);
        sh3 = findViewById(R.id.s3);
        sh4 = findViewById(R.id.s4);

        ar1 = findViewById(R.id.a1);
        ar2 = findViewById(R.id.a2);
        ar3 = findViewById(R.id.a3);
        ar4 = findViewById(R.id.a4);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String che1 = ch1.getText().toString();
                String che2 = ch2.getText().toString();
                String che3 = ch3.getText().toString();
                String che4 = ch4.getText().toString();

                String leg1 = le1.getText().toString();
                String leg2 = le2.getText().toString();
                String leg3 = le3.getText().toString();
                String leg4 = le4.getText().toString();

                String sho1 = sh1.getText().toString();
                String sho2 = sh2.getText().toString();
                String sho3 = sh3.getText().toString();
                String sho4 = sh4.getText().toString();

                String arm1 = ar1.getText().toString();
                String arm2 = ar2.getText().toString();
                String arm3 = ar3.getText().toString();
                String arm4 = ar4.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("Exercise");

                HashMap hashMap = new HashMap();

                hashMap.put("Chest1",che1);
                hashMap.put("Chest2",che2);
                hashMap.put("Chest3",che3);
                hashMap.put("Chest4",che4);

                hashMap.put("Leg1",leg1);
                hashMap.put("Leg2",leg2);
                hashMap.put("Leg3",leg3);
                hashMap.put("Leg4",leg4);

                hashMap.put("Shoulders1",sho1);
                hashMap.put("Shoulders2",sho2);
                hashMap.put("Shoulders3",sho3);
                hashMap.put("Shoulders4",sho4);

                hashMap.put("Arms1",arm1);
                hashMap.put("Arms2",arm2);
                hashMap.put("Arms3",arm3);
                hashMap.put("Arms4",arm4);


                ref.child("Ex3").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Data updated successfully!",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),category3.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}