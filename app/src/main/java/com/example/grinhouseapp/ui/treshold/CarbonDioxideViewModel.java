package com.example.grinhouseapp.ui.treshold;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;

public class CarbonDioxideViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public CarbonDioxideViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
