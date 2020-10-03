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

public class BentOver extends AppCompatActivity {

    Button btn, updatebtn,  deletebtn;
    TextView eypment, cheststep1, cheststep2;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bent_over);

        btn = findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddBentOver.class);
                startActivity(i);
            }
        });

        eypment = findViewById(R.id.eq1);
        cheststep1 = findViewById(R.id.st1);
        cheststep2 = findViewById(R.id.st2);

        String eq1 = getIntent().getStringExtra("f0");
        String st1 = getIntent().getStringExtra("f1");
        String st2 = getIntent().getStringExtra("f2");

        eypment.setText(eq1);
        cheststep1.setText(st1);
        cheststep2.setText(st2);

        updatebtn = findViewById(R.id.button6);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = eypment.getText().toString();
                String data2 = cheststep1.getText().toString();
                String data3 = cheststep2.getText().toString();

                Intent i3 = new Intent(getApplicationContext(),UpdateBentOverRow.class);

                i3.putExtra("f0", data);
                i3.putExtra("f1", data2);
                i3.putExtra("f2", data3);

                startActivity(i3);
            }
        });

        deletebtn = findViewById(R.id.button61);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainPage.class);
                startActivity(i);
                DatabaseReference db1 = FirebaseDatabase.getInstance().getReference().child("BentOverRow");
                db1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("item1")){
                            ref = FirebaseDatabase.getInstance().getReference().child("BentOverRow").child("item1");
                            ref.removeValue();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfull", Toast.LENGTH_LONG).show();
                        }

                        else
                            Toast.makeText(getApplicationContext(),"No Source TO Delete", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }


}