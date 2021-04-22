package com.example.grinhouseapp.treshold;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;

public class TemperatureViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public TemperatureViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }

    LiveData<Measurement> getMeasurement()
    {
        return measurementRepository.getMeasurement();
    }

    public void setMeasurementRepository(int type)
    {
        measurementRepository.setMeasurement(type);
    }
}