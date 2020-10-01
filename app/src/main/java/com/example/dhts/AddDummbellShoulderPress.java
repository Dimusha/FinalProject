package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDummbellShoulderPress extends AppCompatActivity {

    EditText stp1, stp2, equp1;
    Button btn;
    DatabaseReference db;
    Adding1 add;

    private void clearControls(){
        stp1.setText("");
        stp2.setText("");
        equp1.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dummbell_shoulder_press);

        add = new Adding1();

        equp1 = findViewById(R.id.editTextTextMultiLine2);
        stp1  = findViewById(R.id.editTextTextMultiLine);
        stp2 = findViewById(R.id.editTextTextMultiLine3);
        btn = findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db= FirebaseDatabase.getInstance().getReference().child("DoumbleShoulderPress");

                add.setEqupments(equp1.getText().toString().trim());
                add.setSteps1(stp1.getText().toString().trim());
                add.setSteps2(stp2.getText().toString().trim());

                db.child("item1").setValue(add);


                String data1 = equp1.getText().toString();
                String data2 = stp1.getText().toString();
                String data3 = stp2.getText().toString();

                Intent i3  = new Intent(getApplicationContext(),DummbellShoulderPress.class);

                i3.putExtra("f0", data1);
                i3.putExtra("f1", data2);
                i3.putExtra("f2", data3);

                startActivity(i3);


            }
        });
    }
}