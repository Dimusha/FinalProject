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

public class tricepdips extends AppCompatActivity {
    Button e1,upplank,delbut;
    TextView adin1,adin2,adin3;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricepdips);

        upplank = findViewById(R.id.updatetricepdip);
        delbut = findViewById(R.id.deletetricepdip);

        e1 = findViewById(R.id.addingtricepdip);
        adin1 =findViewById(R.id.info1);
        adin2 =findViewById(R.id.info2);
        adin3 =findViewById(R.id.info3);

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3  = new Intent(getApplicationContext(),addingtricepdips.class);
                startActivity(i3);

            }
        });

        upplank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = adin1.getText().toString();
                String data2 = adin2.getText().toString();
                String data3 = adin3.getText().toString();

                Intent i4 = new Intent(getApplicationContext(),updatetricepdips.class);

                i4.putExtra("f0", data);
                i4.putExtra("f1", data2);
                i4.putExtra("f2", data3);

                startActivity(i4);
            }
        });

        String i1 = getIntent().getStringExtra("f0");
        String i2 = getIntent().getStringExtra("f1");
        String i3 = getIntent().getStringExtra("f2");



        adin1.setText(i1);
        adin2.setText(i2);
        adin3.setText(i3);

        delbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("tricepdips");
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Additional info")){
                            ref =  FirebaseDatabase.getInstance().getReference().child("tricepdips").child("Additional info");
                            ref.removeValue();
                            Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_LONG).show();

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to delete",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });
                Intent it = new Intent(getApplicationContext(),withoutActivity.class);
                startActivity(it);


            }
        });
    }
}