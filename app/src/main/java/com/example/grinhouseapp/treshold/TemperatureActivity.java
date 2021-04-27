package com.example.grinhouseapp.treshold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.grinhouseapp.MainActivity;
import com.example.grinhouseapp.R;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.Timer;
import java.util.TimerTask;

public class TemperatureActivity extends AppCompatActivity {

    TemperatureViewModel temperatureViewModel;
    TextView textView;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        textView = findViewById(R.id.degrees);
        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);


        Intent bundle = getIntent();
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}