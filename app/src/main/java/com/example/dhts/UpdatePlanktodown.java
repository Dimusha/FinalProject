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

public class UpdatePlanktodown extends AppCompatActivity {

    EditText upinfo1,upinfo2,upinfo3;
    Button update;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_planktodown);

        upinfo1 = findViewById(R.id.addi1);
        upinfo2 = findViewById(R.id.addi2);
        upinfo3 = findViewById(R.id.addi3);
        update = findViewById(R.id.upbi);

        String in1 = getIntent().getStringExtra("f0");
        String in2 = getIntent().getStringExtra("f1");
        String in3 = getIntent().getStringExtra("f2");

        upinfo1.setText(in1);
        upinfo2.setText(in2);
        upinfo3.setText(in3);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info1 = upinfo1.getText().toString();
                String info2 = upinfo2.getText().toString();
                String info3 = upinfo3.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("planktodown");

                HashMap hashMap = new HashMap();

                hashMap.put("addi1", info1);
                hashMap.put("addi2", info2);
                hashMap.put("addi3", info3);



                ref.child("Additional info").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {

                    String data1 = upinfo1.getText().toString();
                    String data2 = upinfo2.getText().toString();
                    String data3 = upinfo3.getText().toString();

                    @Override
                    public void onSuccess(Object o) {

                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), planktdown.class);


                        i.putExtra("f0", data1);
                        i.putExtra("f1",data2);
                        i.putExtra("f2",data3);
                        startActivity(i);

                    }
                });
            }
        });
    }
}