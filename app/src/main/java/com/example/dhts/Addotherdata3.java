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

public class Addotherdata3 extends AppCompatActivity {

    EditText time, date, name;
    Button buttn;
    DatabaseReference ref;
    AddData3 add3;

    AwesomeValidation awesomeValidation;


    private void clear() {

        time.setText("");
        date.setText("");
        name.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addotherdata3);
        time = findViewById(R.id.nameAd3);
        date = findViewById(R.id.editDate3);
        name = findViewById(R.id.MultiLine3);

        awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.nameAd3,
                RegexTemplate.NOT_EMPTY,R.string.invalid_time);
        awesomeValidation.addValidation(this,R.id.editDate3,
                RegexTemplate.NOT_EMPTY,R.string.invalid_time);
        awesomeValidation.addValidation(this,R.id.MultiLine3,
                RegexTemplate.NOT_EMPTY,R.string.invalid_time );

        buttn = findViewById(R.id.buttontest3);
        add3 = new AddData3();
        buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate()) {
                    ref = FirebaseDatabase.getInstance().getReference().child("AddData3");

                    add3.setTime(time.getText().toString().trim());
                    add3.setDate(date.getText().toString().trim());
                    add3.setNote(name.getText().toString().trim());

                    ref.child("Legs").setValue(add3);

                    String detail = time.getText().toString();
                    String detail1 = date.getText().toString();
                    String detail2 = name.getText().toString();

                    Intent i = new Intent(getApplicationContext(), view3.class);

                    i.putExtra("d4", detail);
                    i.putExtra("d5", detail1);
                    i.putExtra("d6", detail2);

                    startActivity(i);

                    Toast.makeText(getApplicationContext(), "Data Inserted Successfull", Toast.LENGTH_LONG).show();
                    clear();


                } else {
                    Toast.makeText(getApplicationContext(), "Validation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
