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

public class OUpdate extends AppCompatActivity {

    EditText tex1,tex2,tex3;
    DatabaseReference ref;
    Button btn8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_update);

        tex1 = findViewById(R.id.Name6);
        tex2 = findViewById(R.id.Name7);
        tex3 = findViewById(R.id.Name8);


        String nn = getIntent().getStringExtra("d1");
        String nm = getIntent().getStringExtra("d2");
        String nu = getIntent().getStringExtra("d3");


        tex1.setText(nn);
        tex2.setText(nm);
        tex3.setText(nu);

        btn8 = findViewById(R.id.buttonsub);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i8 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i8);

                String nn = tex1.getText().toString();
                String nm = tex2.getText().toString();
                String nu = tex3.getText().toString();


                ref = FirebaseDatabase.getInstance().getReference().child("addData");

                HashMap hashMap = new HashMap();


                hashMap.put("date",nn);
                hashMap.put("name",nm);
                hashMap.put("supnum",nu);

                ref.child("Shoulders").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Update Successfully",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });



    }
}