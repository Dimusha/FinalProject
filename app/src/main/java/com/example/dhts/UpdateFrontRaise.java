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

public class UpdateFrontRaise extends AppCompatActivity {


    EditText eq, st1, st2;
    Button update;
    DatabaseReference ref;

    private void clearControls() {
        eq.setText("");
        st1.setText("");
        st2.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_front_raise);

        eq = findViewById(R.id.eq1);
        st1 = findViewById(R.id.editTextTextMultiLine2);
        st2 = findViewById(R.id.editTextTextMultiLine3);
        update = findViewById(R.id.button3);

        String equp1 = getIntent().getStringExtra("f0");
        String setp1 = getIntent().getStringExtra("f1");
        String setp2 = getIntent().getStringExtra("f2");

        eq.setText(equp1);
        st1.setText(setp1);
        st2.setText(setp2);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String equipment = eq.getText().toString();
                String stepp1 = st1.getText().toString();
                String stepp2 = st2.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("DummbellFrontRaise");

                HashMap hashMap = new HashMap();

                hashMap.put("additional1", equipment);
                hashMap.put("additional2", stepp1);
                hashMap.put("additional3", stepp2);
                ref.child("item1").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {

                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainPage.class);
                        startActivity(i);

                    }
                });


            }

        });
    }
}