package com.example.grinhouseapp.treshold;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.architecture.measurement.MeasurementRepository;

public class CarbonDioxideViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public CarbonDioxideViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
