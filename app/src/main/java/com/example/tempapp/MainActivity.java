package com.example.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

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
import java.time.MonthDay;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();


        }
    }

     Button b1 = (Button)findViewById(R.id.button);
     Button b2 = (Button)findViewById(R.id.button2);


     public void onClick(View v){
         Clicktemperature();
          ClickHumidity();
     }

     public void Clicktemperature() {

         Intent intent = new Intent (this,Temperature.class);
         startActivity(intent);

     }

    public void ClickHumidity() {

        Intent intent = new Intent (this,Humidity.class);
        startActivity(intent);

    }



    public void weather() {

        final TextView t1_temp = findViewById(R.id.t1);
        final TextView t2_hum = findViewById(R.id.t2);

        String url = "http://sairamaraov.github.io/temp.json";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject json = response.getJSONObject("Temperature");
                    JSONObject json1 = response.getJSONObject("Humidity");
                    String temp = String.valueOf(json.getDouble("temp"));
                    String humi = String.valueOf(json1.getDouble("humi"));

                    t1_temp.setText(temp);
                    t2_hum.setText(humi);

                } catch (JSONException e) {

                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);

    }


   }







