package com.example.grinhouseapp.treshold;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.List;

public class HumidityViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public HumidityViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }
}
