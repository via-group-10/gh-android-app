package com.example.grinhouseapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.treshold.CarbonDioxideActivity;
import com.example.grinhouseapp.treshold.TemperatureActivity;

import com.example.grinhouseapp.model.MeasurementType;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView temperatureTextView;
    TextView co2TextView;
    TextView humidityTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.setMeasurementRepository();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                homeViewModel.setMeasurementRepository();
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes temperature is updated)

        //temperature
        temperatureTextView = root.findViewById(R.id.text_temData);
        temperatureTextView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            temperatureTextView.setText(homeViewModel.getLatestMeasurement(MeasurementType.temperature).getMeasurementValue() + "℃");
        });


        //co2
        co2TextView = root.findViewById(R.id.text_cdData);
        co2TextView.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), CarbonDioxideActivity.class);
            startActivity(intentco2);
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            co2TextView.setText(homeViewModel.getLatestMeasurement(MeasurementType.carbonDioxide).getMeasurementValue() + "ppm");
        });

        //humidity
        humidityTextView = root.findViewById(R.id.text_humData);
        humidityTextView.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), CarbonDioxideActivity.class);
            startActivity(intentco2);
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            humidityTextView.setText(homeViewModel.getLatestMeasurement(MeasurementType.humidity).getMeasurementValue() + "%");
        });

        return root;
    }
}