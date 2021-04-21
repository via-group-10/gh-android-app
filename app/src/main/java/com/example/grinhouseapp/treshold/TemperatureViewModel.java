package com.example.grinhouseapp.treshold;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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