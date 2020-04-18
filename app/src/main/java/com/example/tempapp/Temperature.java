package com.example.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tempapp.ui.main.MainFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import com.example.tempapp.ui.temperature.TemperatureFragment;

public class Temperature extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TemperatureFragment.newInstance())
                    .commitNow();
        }

        Button b4 = (Button) findViewById(R.id.button_lastweek);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMain();
            }

            public void ClickMain(){
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}