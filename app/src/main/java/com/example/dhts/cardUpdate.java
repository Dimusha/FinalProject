package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class cardUpdate extends AppCompatActivity {

    TextView cName,cNum,cvc;
    Spinner month,year;
    Button button;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_update);

        final String s1=getIntent().getStringExtra("key");

        cName = findViewById(R.id.cName);
        cNum = findViewById(R.id.cNumber);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        cvc = findViewById(R.id.cvc);

        String cNm = getIntent().getStringExtra("cName");
        String cNumb = getIntent().getStringExtra("cNumber");
        String cvcN = getIntent().getStringExtra("cvc");
        //String mon = getIntent().getStringExtra("mo");
        //String yer = getIntent().getStringExtra("yr");

        cName.setText(cNm);
        cNum.setText(cNumb);
        cvc.setText(cvcN);
        //month.setText(mon);
        //year.setText(yer);

        button = findViewById(R.id.upBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = cName.getText().toString();
                String num = cNum.getText().toString();
                String cc = cvc.getText().toString();
                String mo = month.getSelectedItem().toString();
                String yr = year.getSelectedItem().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("Card");

                HashMap hashMap = new HashMap();

                hashMap.put("cName", nm);
                hashMap.put("cNumber", num);
                hashMap.put("cvc", cc);
                hashMap.put("month", mo);
                hashMap.put("year", yr);

                ref.child(s1).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(), "Successfully updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(),SpecialPlan.class);
                        startActivity(i);
                    }
                });
            }
        });

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"UPDATE CARD DETAILS!",Toast.LENGTH_LONG);
        toast.show();
    }
}