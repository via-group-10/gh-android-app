package com.example.grinhouseapp.treshold;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.architecture.measurement.MeasurementRepository;

public class HumidityViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public HumidityViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
