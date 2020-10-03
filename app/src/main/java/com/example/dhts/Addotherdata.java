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

public class Addotherdata extends AppCompatActivity {

    EditText text1,text2,text3;
    Button buttest;
    DatabaseReference ref;
    addData add;

    AwesomeValidation awesomeValidation;




    private void clear(){

        text1.setText("");
        text2.setText("");
        text3.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addotherdata);
        text1 =findViewById(R.id.nameAd);
        text2 =findViewById(R.id.editDate);
        text3 =findViewById(R.id.MultiLine);

        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.nameAd,
                RegexTemplate.NOT_EMPTY,R.string.invalid_time);
        awesomeValidation.addValidation(this,R.id.editDate,
                RegexTemplate.NOT_EMPTY,R.string.invalid_date);
        awesomeValidation.addValidation(this,R.id.MultiLine,
                RegexTemplate.NOT_EMPTY,R.string.invalid_note );


        buttest = findViewById(R.id.buttontest);
        add = new addData();
        buttest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    ref = FirebaseDatabase.getInstance().getReference().child("addData");

                    add.setName(text1.getText().toString().trim());
                    add.setDate(text2.getText().toString().trim());
                    add.setNote(text3.getText().toString().trim());

                    ref.child("Shoulders").setValue(add);

                    String detail = text1.getText().toString();
                    String detail1 = text2.getText().toString();
                    String detail2 = text3.getText().toString();

                    Intent i = new Intent(getApplicationContext(), view.class);

                    i.putExtra("d1", detail);
                    i.putExtra("d2", detail1);
                    i.putExtra("d3", detail2);

                    startActivity(i);

                    Toast.makeText(getApplicationContext(), "Data Inserted Successfull", Toast.LENGTH_LONG).show();
                    clear();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Validation Failed",Toast.LENGTH_SHORT).show();
                }





            }
        });

    }
}