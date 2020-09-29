package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class FrontRaisesViewPage extends AppCompatActivity {

    TextView eypment, cheststep1, cheststep2;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_raises_view_page);

        eypment = findViewById(R.id.editTextTextMultiLine2);
        cheststep1 = findViewById(R.id.editTextTextMultiLine);
        cheststep2 = findViewById(R.id.editTextTextMultiLine3);

        String sequp = getIntent().getStringExtra("f0");
        String sstep1 = getIntent().getStringExtra("f1");
        String sstep2 = getIntent().getStringExtra("f2");

        eypment.setText(sequp);
        cheststep1.setText(sstep1);
        cheststep2.setText(sstep2);

    }
}