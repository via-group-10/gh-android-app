package com.example.grinhouseapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.treshold.HumidityActivity;
import com.example.grinhouseapp.treshold.TemperatureActivity;

import com.example.grinhouseapp.treshold.TemperatureViewModel;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TemperatureViewModel temperatureViewModel;
    TextView temData;
    TextView humData;
    TextView cdData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        temData= (TextView) root.findViewById(R.id.text_temData);
        temData.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        humData = (TextView) root.findViewById(R.id.text_humData);
        humData.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HumidityActivity.class);
            startActivity(intent);
        });

        cdData = root.findViewById(R.id.text_cdData);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                homeViewModel.getTemperature();
                homeViewModel.getCarbonDioxide();
                homeViewModel.getHumidity();
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes temperature is updated)



        homeViewModel.getTemperature().observe(getViewLifecycleOwner(), measurement -> {
            temData.setText(measurement.getMeasurementValue() + "℃");
            Log.i("Temperature", measurement.getMeasurementValue()+"");
        });

        homeViewModel.getHumidity().observe(getViewLifecycleOwner(),measurement -> {
            humData.setText(measurement.getMeasurementValue() + "%");
            Log.i("Humidity", measurement.getMeasurementValue()+"");
        });

        homeViewModel.getCarbonDioxide().observe(getViewLifecycleOwner(),measurement -> {
            System.out.println(measurement.getMeasurementValue()+">>>>");
            cdData.setText(measurement.getMeasurementValue() + "ppm");
            Log.i("CarbonDioxide", measurement.getMeasurementValue()+"");
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(),measurement -> {

        });

        return root;

    }


}