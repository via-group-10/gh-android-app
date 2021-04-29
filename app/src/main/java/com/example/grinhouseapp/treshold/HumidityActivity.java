package com.example.grinhouseapp.treshold;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;

public class HumidityActivity extends AppCompatActivity {

    HumidityViewModel humidityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);
        humidityViewModel = new ViewModelProvider(this).get(HumidityViewModel.class);

        Intent bundle = getIntent();
        Toolbar toolbar = findViewById(R.id.up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}


