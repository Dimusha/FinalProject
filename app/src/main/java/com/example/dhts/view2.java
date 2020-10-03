package com.example.dhts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class view2 extends AppCompatActivity {

    TextView tex1,tex2,tex3;
    Button btn2,btn3,btn4;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);

        tex1 = findViewById(R.id.View50);
        tex2 = findViewById(R.id.View51);
        tex3 = findViewById(R.id.View52);

        String tt = getIntent().getStringExtra("da");
        String td = getIntent().getStringExtra("db");
        String tn = getIntent().getStringExtra("dc");

        tex1.setText(tt);
        tex2.setText(td);
        tex3.setText(tn);

        btn2 =findViewById(R.id.update2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tt = tex1.getText().toString();
                String td = tex2.getText().toString();
                String tn = tex3.getText().toString();

                Intent i2 = new Intent(getApplicationContext(),ABsUpdate.class);


                i2.putExtra("da",tt);
                i2.putExtra("db",td);
                i2.putExtra("dc",tn);

                startActivity(i2);



            }
        });

        btn3 = findViewById(R.id.Delete2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i3);

                final DatabaseReference delrRef = FirebaseDatabase.getInstance().getReference().child("AddData2");
                delrRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("AddData2").child("abs");
                        dbRef.removeValue();
                        Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btn4=findViewById(R.id.done2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i4);

                Toast.makeText(getApplicationContext(),"Daily plan SUBMITED",Toast.LENGTH_SHORT).show();
            }
        });

    }
}