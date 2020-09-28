package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class CARD_DETAILS extends AppCompatActivity {

    ImageButton button,btn;
    EditText cName,cNum,cvc;
    Spinner month,year;
    DatabaseReference ref;
    Card card;

    private void clear(){
        cName.setText("");
        cNum.setText("");
        cvc.setText("");
        month.setSelected(Boolean.parseBoolean(""));
        year.setSelected(Boolean.parseBoolean(""));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_a_r_d__d_e_t_a_i_l_s);

        card = new Card();

        cName = findViewById(R.id.cName);
        cNum = findViewById(R.id.cNumber);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        cvc = findViewById(R.id.cvc);


        button = findViewById(R.id.ib3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref = FirebaseDatabase.getInstance().getReference().child("Card");

                card.setcName(cName.getText().toString().trim());
                card.setcNumber(cNum.getText().toString().trim());
                card.setMonth(month.getSelectedItem().toString().trim());
                card.setYear(year.getSelectedItem().toString().trim());
                card.setCvc(cvc.getText().toString().trim());

                ref.child("Cd").setValue(card);

                Toast.makeText(getApplicationContext(),"data inserted successfully",Toast.LENGTH_SHORT).show();
                clear();

                Intent i = new Intent(getApplicationContext(),SpecialPlan.class);
                startActivity(i);
            }
        });

        btn = findViewById(R.id.ib4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),cardUpdate.class);
                startActivity(i);
            }
        });
    }
}