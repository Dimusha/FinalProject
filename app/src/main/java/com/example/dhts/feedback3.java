package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback3 extends AppCompatActivity {

    EditText nm,com;
    Spinner rate;
    ImageButton btn;
    DatabaseReference ref;
    Feed feed;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback3);

        feed = new Feed();

        nm = findViewById(R.id.name);
        com = findViewById(R.id.comment);
        rate = findViewById(R.id.num);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.name,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_name);
        awesomeValidation.addValidation(this,R.id.comment,
                RegexTemplate.NOT_EMPTY,R.string.Invalid_comment);

        btn = findViewById(R.id.feed);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {

                    ref = FirebaseDatabase.getInstance().getReference().child("Feedback3");

                    String FeedId = ref.push().getKey();

                    feed.setName(nm.getText().toString().trim());
                    feed.setComment(com.getText().toString().trim());
                    feed.setNumber(rate.getSelectedItem().toString().trim());

                    ref.child(FeedId).setValue(feed);

                    String data1 = nm.getText().toString().trim();
                    String data2 = com.getText().toString().trim();
                    String data3 = rate.getSelectedItem().toString().trim();

                    Intent i = new Intent(getApplicationContext(), viewFeed3.class);
                    i.putExtra("key", FeedId);
                    Toast.makeText(getApplicationContext(), "key" + FeedId, Toast.LENGTH_SHORT).show();

                    i.putExtra("nm", data1);
                    i.putExtra("cm", data2);
                    i.putExtra("rt", data3);

                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Validation Failed!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}