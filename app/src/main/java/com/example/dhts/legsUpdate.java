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

public class legsUpdate extends AppCompatActivity {


    EditText atime,adate,anote;
    DatabaseReference dbref;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_update);

        atime = findViewById(R.id.Name12);
        adate = findViewById(R.id.Name13);
       anote = findViewById(R.id.Name14);

        String nn = getIntent().getStringExtra("d4");
        String nm = getIntent().getStringExtra("d5");
        String nu = getIntent().getStringExtra("d6");

        atime.setText(nn);
        adate.setText(nm);
        anote.setText(nu);

        bt=findViewById(R.id.buttonsub3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i7);

                String nn = atime.getText().toString();
                String nm = adate.getText().toString();
                String nu = anote.getText().toString();


                dbref = FirebaseDatabase.getInstance().getReference().child("AddData3");

                HashMap hashMap = new HashMap();

                hashMap.put("dateAdd",nn);
                hashMap.put("date",nm);
                hashMap.put("note",nu);

                dbref.child("Legs").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}