package com.example.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tempapp.ui.humidity.HumidityFragment;

public class Humidity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humidity_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, HumidityFragment.newInstance())
                    .commitNow();
        }
    }

    Button b5 = (Button) findViewById(R.id.button_nextweek);

    public void ClickBack(View view) {

        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent2);

    }
}







