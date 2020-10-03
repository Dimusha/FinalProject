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

public class Addotherdata2 extends AppCompatActivity {

    EditText namead,timead,notead;
    Button btn;
    DatabaseReference dbRef;
    AddData2 add2;

    AwesomeValidation awesomeValidation;

    private void clear(){

        namead.setText("");
        timead.setText("");
        notead.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addotherdata2);

        namead =findViewById(R.id.nameAd2);
        timead =findViewById(R.id.editDate2);
        notead =findViewById(R.id.MultiLine2);


        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.nameAd2,
                RegexTemplate.NOT_EMPTY,R.string.invalid_time);
        awesomeValidation.addValidation(this,R.id.editDate2,
                RegexTemplate.NOT_EMPTY,R.string.invalid_date);
        awesomeValidation.addValidation(this,R.id.MultiLine2,
                RegexTemplate.NOT_EMPTY,R.string.invalid_note );

        btn = findViewById(R.id.buttontest2);
        add2 = new AddData2();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    dbRef = FirebaseDatabase.getInstance().getReference().child("AddData2");

                    add2.setDateAdd(namead.getText().toString().trim());
                    add2.setTimeAdd(timead.getText().toString().trim());
                    add2.setNoteAdd(notead.getText().toString().trim());

                    dbRef.child("abs").setValue(add2);

                    String deta = namead.getText().toString();
                    String deta1 = timead.getText().toString();
                    String deta2 = notead.getText().toString();

                    Intent i = new Intent(getApplicationContext(), view2.class);

                    i.putExtra("da", deta);
                    i.putExtra("db", deta1);
                    i.putExtra("dc", deta2);

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