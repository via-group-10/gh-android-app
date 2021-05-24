package com.example.grinhouseapp.ui.treshold;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;

public class HumidityViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public HumidityViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
