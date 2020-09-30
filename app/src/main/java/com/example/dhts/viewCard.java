package com.example.dhts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewCard extends AppCompatActivity {

    ImageButton button,btn,bt;
    TextView cName,cNum,cvc,month,year;
    DatabaseReference ref;

    public void clear(){
        cName.setText("");
        cNum.setText("");
        cvc.setText("");
        month.setText("");
        year.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_card);

        cName = findViewById(R.id.cName);
        cNum = findViewById(R.id.cNumber);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        cvc = findViewById(R.id.cvc);

        String cNm = getIntent().getStringExtra("cN");
        String cNumb = getIntent().getStringExtra("cNu");
        String cvcN = getIntent().getStringExtra("cc");
        String mon = getIntent().getStringExtra("mo");
        String yer = getIntent().getStringExtra("yr");

        cName.setText(cNm);
        cNum.setText(cNumb);
        cvc.setText(cvcN);
        month.setText(mon);
        year.setText(yer);

        button = findViewById(R.id.ib3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SpecialPlan.class);
                startActivity(i);
            }
        });

        btn = findViewById(R.id.ib4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = cName.getText().toString().trim();
                String data2 = cNum.getText().toString().trim();
                //String data3 = month.getText().toString().trim();
                //String data4 = year.getText().toString().trim();
                String data5 = cvc.getText().toString().trim();

                Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),cardUpdate.class);

                i.putExtra("cName",data1);
                i.putExtra("cNumber",data2);
                //i.putExtra("mo",data3);
                //i.putExtra("yr",data4);
                i.putExtra("cvc",data5);

                startActivity(i);
            }
        });

        bt= findViewById(R.id.delete);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dlRef = FirebaseDatabase.getInstance().getReference().child("Card");
                dlRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Cd")){
                            ref =FirebaseDatabase.getInstance().getReference().child("Card").child("Cd");
                            ref.removeValue();
                            clear();
                            Toast.makeText(getApplicationContext(),"Deleted successfully!",Toast.LENGTH_LONG).show();


                            Intent i = new Intent(getApplicationContext(),CARD_DETAILS.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No source to delete!",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}