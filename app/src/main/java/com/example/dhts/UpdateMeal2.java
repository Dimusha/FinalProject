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

public class UpdateMeal2 extends AppCompatActivity {

    EditText bf,lu,sn,di;
    Button btn;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_meal2);

        bf = findViewById(R.id.bf);
        lu = findViewById(R.id.lu);
        sn = findViewById(R.id.sn);
        di = findViewById(R.id.di);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bFast = bf.getText().toString();
                String lunch = lu.getText().toString();
                String snack = sn.getText().toString();
                String dinner = di.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("MealPlan");

                HashMap hashMap = new HashMap();

                hashMap.put("Breakfast",bFast);
                hashMap.put("Lunch",lunch);
                hashMap.put("Snack",snack);
                hashMap.put("Dinner",dinner);

                ref.child("Plan2").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Data updated successfully!",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),category2.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}