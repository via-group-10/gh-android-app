package com.example.grinhouseapp.ui.treshold;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;

public class TemperatureViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public TemperatureViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
