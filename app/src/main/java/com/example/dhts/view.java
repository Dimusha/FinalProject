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

public class view extends AppCompatActivity {

    TextView textime,texdate,textnote;
    Button btn4,btn5,btn6;
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textime = findViewById(R.id.View36);
        texdate = findViewById(R.id.View37);
        textnote = findViewById(R.id.View40);

        String tt = getIntent().getStringExtra("d1");
        String td = getIntent().getStringExtra("d2");
        String tn = getIntent().getStringExtra("d3");

        textime.setText(tt);
        texdate.setText(td);
        textnote.setText(tn);


        btn4 = findViewById(R.id.update1);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tt = textime.getText().toString();
                String td = texdate.getText().toString();
                String tn = textnote.getText().toString();

                Intent i2 = new Intent(getApplicationContext(),OUpdate.class);


                i2.putExtra("d1",tt);
                i2.putExtra("d2",td);
                i2.putExtra("d3",tn);

                startActivity(i2);

            }
        });
        btn5 = findViewById(R.id.Delete);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i3);

                final DatabaseReference delrRef = FirebaseDatabase.getInstance().getReference().child("addData");
                delrRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dbRef = FirebaseDatabase.getInstance().getReference().child("addData").child("Data");
                        dbRef.removeValue();
                        Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btn6=findViewById(R.id.done);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i4);

                Toast.makeText(getApplicationContext(),"Daily plan SUBMITED",Toast.LENGTH_SHORT).show();
            }
        });



    }
}