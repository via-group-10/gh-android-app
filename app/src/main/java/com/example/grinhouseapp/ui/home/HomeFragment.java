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
import com.example.grinhouseapp.treshold.CarbonDioxideActivity;
import com.example.grinhouseapp.treshold.CarbonDioxideViewModel;
import com.example.grinhouseapp.treshold.TemperatureActivity;

import com.example.grinhouseapp.treshold.TemperatureViewModel;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TextView textView;
    TextView co2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

       //temperature
        textView= (TextView) root.findViewById(R.id.text_temData);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        homeViewModel.setMeasurementRepository();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                homeViewModel.setMeasurementRepository();
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes temperature is updated)



        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            textView.setText(homeViewModel.getLastMeasurement(MeasurementType.temperature).getMeasurementValue() + "℃");
        });


        //co2
        co2 = root.findViewById(R.id.text_cdData);
        co2.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), CarbonDioxideActivity.class);
            startActivity(intentco2);
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            co2.setText(homeViewModel.getLastMeasurement(MeasurementType.carbonDioxide).getMeasurementValue() + "ppm");
        });

        //humidity
        co2 = root.findViewById(R.id.text_humData);
        co2.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), CarbonDioxideActivity.class);
            startActivity(intentco2);
        });

        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            co2.setText(homeViewModel.getLastMeasurement(MeasurementType.humidity).getMeasurementValue() + "%");
        });

        return root;
    }
}

