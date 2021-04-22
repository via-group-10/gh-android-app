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

import java.util.Timer;
import java.util.TimerTask;

public class TemperatureActivity extends AppCompatActivity {

    TemperatureViewModel temperatureViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        textView = findViewById(R.id.textView8);
        temperatureViewModel = new ViewModelProvider(this).get(TemperatureViewModel.class);

        temperatureViewModel.setMeasurementRepository(1);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                temperatureViewModel.setMeasurementRepository(1);
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes temperature is updated)



        temperatureViewModel.getMeasurement().observe(this, measurement -> {
            textView.setText(measurement.getValue() + "℃");
        });

        Intent bundle = getIntent();
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}