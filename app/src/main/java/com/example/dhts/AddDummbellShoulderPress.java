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

public class AddDummbellShoulderPress extends AppCompatActivity {

    EditText stp1, stp2, equp1;
    Button btn;
    DatabaseReference db;
    Adding1 add;

    AwesomeValidation awesomeValidation;

    private void clearControls(){
        stp1.setText("");
        stp2.setText("");
        equp1.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dummbell_shoulder_press);

        add = new Adding1();

        equp1 = findViewById(R.id.editTextTextMultiLine2);
        stp1  = findViewById(R.id.editTextTextMultiLine);
        stp2 = findViewById(R.id.editTextTextMultiLine3);
        btn = findViewById(R.id.button3);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.editTextTextMultiLine2, RegexTemplate.NOT_EMPTY,R.string.invalid_data);
        awesomeValidation.addValidation(this,R.id.editTextTextMultiLine, RegexTemplate.NOT_EMPTY,R.string.invalid_data);
        awesomeValidation.addValidation(this,R.id.editTextTextMultiLine3, RegexTemplate.NOT_EMPTY,R.string.invalid_data);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()) {

                db= FirebaseDatabase.getInstance().getReference().child("DoumbleShoulderPress");

                add.setAdditional1(equp1.getText().toString().trim());
                add.setAdditional2(stp1.getText().toString().trim());
                add.setAdditional3(stp2.getText().toString().trim());

                db.child("item1").setValue(add);


                String data1 = equp1.getText().toString();
                String data2 = stp1.getText().toString();
                String data3 = stp2.getText().toString();

                Intent i3  = new Intent(getApplicationContext(),DummbellShoulderPress.class);

                i3.putExtra("f0", data1);
                i3.putExtra("f1", data2);
                i3.putExtra("f2", data3);

                startActivity(i3);


                    Toast.makeText(getApplicationContext(), "Data Insert Successfull", Toast.LENGTH_SHORT);
                    clearControls();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Data Validation Failed", Toast.LENGTH_SHORT);
                }



            }
        });
    }
}