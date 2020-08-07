package com.example.usingstrings;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("LifeCycle","OnCreate() invoked");

        TextView txtMsg2 = findViewById(R.id.TvMsg2);
        txtMsg2.setText(R.string.Msg2);
    }
    public void onStart()
    {
        super.onStart();
        Log.i("LifeCycle","onStart() invoked");
    }

    public void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "onRestart() invoked");
    }

    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume() invoked");
    }

    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause() invoked");
    }

    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop() invoked");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy() invoked");
    }
}