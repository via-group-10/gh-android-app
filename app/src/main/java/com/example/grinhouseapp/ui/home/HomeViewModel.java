package com.example.grinhouseapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

public class HomeViewModel extends ViewModel {

    MeasurementRepository measurementRepository;

    public HomeViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }

    LiveData<List<Measurement>> getMeasurement()
    {
        return measurementRepository.getLatestMeasurements();
    }

    Measurement getLatestMeasurement(MeasurementType type)
    {
        for(Measurement measurement : measurementRepository.getLatestMeasurements().getValue())
        {
            if(measurement.getMeasurementTypeEnum() == type)
                return measurement;
        }
        return null;
    }

    public void setMeasurementRepository()
    {
        measurementRepository.setLatestMeasurements();
    }
}