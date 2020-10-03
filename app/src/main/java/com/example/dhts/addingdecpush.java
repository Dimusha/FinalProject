package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addingdecpush extends AppCompatActivity {

    Button addingbut;
    DatabaseReference db;
    AwesomeValidation awesomeValidation;
    Adding add;
    EditText additional1,additional2,additional3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingdecpush);

        add = new Adding();


        addingbut = findViewById(R.id.adb);
        additional1 = findViewById(R.id.addi1);
        additional2 = findViewById(R.id.addi2);
        additional3 = findViewById(R.id.addi3);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.addi1,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_text);
        awesomeValidation.addValidation(this,R.id.addi2,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_text);
        awesomeValidation.addValidation(this,R.id.addi3,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_text);

        addingbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()) {
                add.setAddi1(additional1.getText().toString().trim());
                add.setAddi2(additional2.getText().toString().trim());
                add.setAddi3(additional3.getText().toString().trim());


                db= FirebaseDatabase.getInstance().getReference().child("declinepushups");


                db.child("Additional info").setValue(add);




                String data1 = additional1.getText().toString();
                String data2 = additional2.getText().toString();
                String data3 = additional3.getText().toString();





                Intent i3  = new Intent(getApplicationContext(),declinepushup.class);

                i3.putExtra("f0", data1);
                i3.putExtra("f1",data2);
                i3.putExtra("f2",data3);




                startActivity(i3);
            }else {

                Toast.makeText(getApplicationContext(),"Validation failed!",Toast.LENGTH_LONG).show();
            }




        }
        });
    }
}