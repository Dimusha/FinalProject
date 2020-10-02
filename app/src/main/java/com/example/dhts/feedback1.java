package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback1 extends AppCompatActivity {

    EditText nm,com;
    Spinner rate;
    ImageButton btn;
    DatabaseReference ref;
    Feed feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback1);

        feed = new Feed();

        nm = findViewById(R.id.name);
        com = findViewById(R.id.comment);
        rate = findViewById(R.id.num);

        btn = findViewById(R.id.feed);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ref = FirebaseDatabase.getInstance().getReference().child("Feedback");

                String FeedId = ref.push().getKey();

                feed.setName(nm.getText().toString().trim());
                feed.setComment(com.getText().toString().trim());
                feed.setNumber(rate.getSelectedItem().toString().trim());

                ref.child(FeedId).setValue(feed);

                String data1 = nm.getText().toString().trim();
                String data2 = com.getText().toString().trim();
                String data3 = rate.getSelectedItem().toString().trim();

                Intent i = new Intent(getApplicationContext(),viewFeed.class);
                i.putExtra("key",FeedId);
                Toast.makeText(getApplicationContext(),"key"+FeedId,Toast.LENGTH_SHORT).show();

                i.putExtra("nm",data1);
                i.putExtra("cm",data2);
                i.putExtra("rt",data3);

                startActivity(i);

            }
        });


    }
}