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

public class CarbonDioxideActivity extends AppCompatActivity {

    CarbonDioxideViewModel carbonDioxideViewModel;
    TextView carbonDioxideData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbondioxide);
//        carbonDioxideData = findViewById(R.id.ppm);
        carbonDioxideViewModel = new ViewModelProvider(this).get(CarbonDioxideViewModel.class);

        carbonDioxideViewModel.setMeasurementRepository();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                carbonDioxideViewModel.setMeasurementRepository();
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes CO2 is updated)

        carbonDioxideViewModel.getMeasurement().observe(this, measurement -> {
            carbonDioxideData.setText(measurement.get(measurement.size()-4).getMeasurementValue() + "ppm");
        });

        Intent bundle = getIntent();
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}


