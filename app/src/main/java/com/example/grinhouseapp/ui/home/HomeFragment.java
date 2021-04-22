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
import com.example.grinhouseapp.treshold.TemperatureActivity;

import com.example.grinhouseapp.treshold.TemperatureViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    TemperatureViewModel temperatureViewModel;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textView= (TextView) root.findViewById(R.id.text_temData);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        homeViewModel.setMeasurementRepository(1);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                homeViewModel.setMeasurementRepository(1);
            }
        }, 5 * 60 * 1000);// Repeat every 5 minutes (every 5 minutes temperature is updated)



        homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurement -> {
            textView.setText(measurement.getValue() + "℃");
        });

        return root;

    }


}