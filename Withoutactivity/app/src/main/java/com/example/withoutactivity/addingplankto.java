package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addingplankto extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;


    Button addingbut,addingim;
    DatabaseReference db;
    ImageView addimage;
    Adding add;
    EditText stepname,desc;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addingplankto);

        add = new Adding();

        addimage = findViewById(R.id.choseim);
        addingim = findViewById(R.id.addingimage);
        addingbut = findViewById(R.id.adb);
        stepname = findViewById(R.id.plankstep);
        desc = findViewById(R.id.descio);

        addingbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add.setStepno(stepname.getText().toString().trim());
                add.setDescription(desc.getText().toString().trim());

                db= FirebaseDatabase.getInstance().getReference().child("planktodown");


                db.push().setValue(add);


                String data1 = stepname.getText().toString();
                String data2 = desc.getText().toString();


                Intent i3  = new Intent(getApplicationContext(),planktodown.class);

                i3.putExtra("f0", data1);
                i3.putExtra("f1",data2);

                startActivity(i3);

            }
        });

        addingim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();

            }
        });
    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            addimage.setImageURI(mImageUri);
        }
    }
}