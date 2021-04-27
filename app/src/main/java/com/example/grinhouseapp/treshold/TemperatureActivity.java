package com.example.grinhouseapp.treshold;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.Timer;
import java.util.TimerTask;

public class TemperatureActivity extends AppCompatActivity {

    TemperatureViewModel temperatureViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);

        Intent bundle = getIntent();
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}


