package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UpdateItemPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item_page);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "EXERCISE UPDATED",Toast.LENGTH_LONG);
        toast.show();
    }
}