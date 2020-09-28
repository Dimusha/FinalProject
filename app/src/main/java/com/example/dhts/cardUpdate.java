package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class cardUpdate extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_update);


    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"UPDATE CARD DETAILS!",Toast.LENGTH_LONG);
        toast.show();
    }
}