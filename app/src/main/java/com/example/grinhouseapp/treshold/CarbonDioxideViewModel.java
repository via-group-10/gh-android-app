package com.example.grinhouseapp.treshold;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.List;

public class CarbonDioxideViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public CarbonDioxideViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }

    LiveData<List<Measurement>> getMeasurement()
    {
        return measurementRepository.getMeasurement();
    }

    public void setMeasurementRepository()
    {
        measurementRepository.setMeasurement();
    }
}
