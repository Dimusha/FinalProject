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

public class view3 extends AppCompatActivity {
    TextView tex1,tex2,tex3;
    Button btn2,btn3,btn4;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view3);

        tex1 = findViewById(R.id.View54);
        tex2 = findViewById(R.id.View55);
        tex3 = findViewById(R.id.View56);

        String tt = getIntent().getStringExtra("d4");
        String td = getIntent().getStringExtra("d5");
        String tn = getIntent().getStringExtra("d6");

        tex1.setText(tt);
        tex2.setText(td);
        tex3.setText(tn);

        btn2 =findViewById(R.id.update3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tt = tex1.getText().toString();
                String td = tex2.getText().toString();
                String tn = tex3.getText().toString();

                Intent i2 = new Intent(getApplicationContext(),legsUpdate.class);


                i2.putExtra("d4",tt);
                i2.putExtra("d5",td);
                i2.putExtra("d6",tn);

                startActivity(i2);



            }
        });

        btn3 = findViewById(R.id.Delete3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i3);

                final DatabaseReference delrRef = FirebaseDatabase.getInstance().getReference().child("AddData3");
                delrRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("AddData3").child("Legs");
                        dbRef.removeValue();
                        Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btn4=findViewById(R.id.done3);
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