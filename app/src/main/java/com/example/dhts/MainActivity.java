package com.example.dhts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name,email,ph,nic;
    //DatePickerDialog.OnDateSetListener setListener;
    ImageButton button,btn;
    DatabaseReference ref;
    Details details;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        ph = findViewById(R.id.number);
        nic = findViewById(R.id.nic);

        details = new Details();

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.name,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_name);
        awesomeValidation.addValidation(this,R.id.email,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_email);
        awesomeValidation.addValidation(this,R.id.nic,
                "[0-9]{9}$",R.string.Invalid_NIC);
        awesomeValidation.addValidation(this,R.id.ph,
                "[0-9]{10}$",R.string.Invalid_mobile_number);


        Toast.makeText(getApplicationContext(),"Configuration successfully!",Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.ib1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){

                    ref = FirebaseDatabase.getInstance().getReference().child("Member");

                    String ItemId = ref.push().getKey();

                    details.setName(name.getText().toString().trim());
                    details.setEmail(email.getText().toString().trim());
                    details.setPhone(ph.getText().toString().trim());
                    details.setNic(nic.getText().toString().trim());

                    ref.child(ItemId).setValue(details);

                    String data1 = name.getText().toString().trim();
                    String data2 = email.getText().toString().trim();
                    String data3 = ph.getText().toString().trim();
                    String data4 = nic.getText().toString().trim();

                    Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),loginDetails.class);
                    i.putExtra("key",ItemId);
                    Toast.makeText(getApplicationContext(),"key"+ItemId,Toast.LENGTH_SHORT).show();

                    i.putExtra("nm",data1);
                    i.putExtra("em",data2);
                    i.putExtra("ph",data3);
                    i.putExtra("nc",data4);

                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Data Inserted Successfully!",Toast.LENGTH_LONG).show();


                }else {

                    Toast.makeText(getApplicationContext(),"Validation failed!",Toast.LENGTH_LONG).show();

                }

                

            }
        });




    }
}