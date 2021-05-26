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

import com.example.grinhouseapp.NetworkCheck;
import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.ui.data.DataViewModel;
import com.example.grinhouseapp.ui.treshold.CarbonDioxideActivity;
import com.example.grinhouseapp.ui.treshold.HumidityActivity;
import com.example.grinhouseapp.ui.treshold.TemperatureActivity;

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

        homeViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        if(NetworkCheck.isInternetAvailable(getContext())) {
            homeViewModel.setMeasurementRepository();

            homeViewModel.getMeasurement().observe(getViewLifecycleOwner(), measurements -> {
                for (Measurement measurement : measurements) {
                    homeViewModel.insertMeasurement(measurement);

                    if (measurement.getMeasurementTypeEnum() == MeasurementType.temperature)
                        temperatureTextView.setText(measurement.getMeasuredValue() + "℃");
                    else if (measurement.getMeasurementTypeEnum() == MeasurementType.carbonDioxide)
                        temperatureTextView.setText(measurement.getMeasuredValue() + "ppm");
                    else
                        temperatureTextView.setText(measurement.getMeasuredValue() + "%");
                }
            });
        }
        else
        {
            homeViewModel.getAllMeasurementsDB().observe(getViewLifecycleOwner(), measurements -> {
                for (Measurement measurement : measurements) {
                    homeViewModel.insertMeasurement(measurement);

                    if (measurement.getMeasurementTypeEnum() == MeasurementType.temperature)
                        temperatureTextView.setText(measurement.getMeasuredValue() + "℃");
                    else if (measurement.getMeasurementTypeEnum() == MeasurementType.carbonDioxide)
                        temperatureTextView.setText(measurement.getMeasuredValue() + "ppm");
                    else
                        temperatureTextView.setText(measurement.getMeasuredValue() + "%");
                }
            });
        }

        //temperature
        temperatureTextView = root.findViewById(R.id.text_temData);
        temperatureTextView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TemperatureActivity.class);
            startActivity(intent);
        });

        //co2
        co2TextView = root.findViewById(R.id.text_cdData);
        co2TextView.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), CarbonDioxideActivity.class);
            startActivity(intentco2);
        });

        //humidity
        humidityTextView = root.findViewById(R.id.text_humData);
        humidityTextView.setOnClickListener(v -> {
            Intent intentco2 = new Intent(getActivity(), HumidityActivity.class);
            startActivity(intentco2);
        });

        return root;
    }
}