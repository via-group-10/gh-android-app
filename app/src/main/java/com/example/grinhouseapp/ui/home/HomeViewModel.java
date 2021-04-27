package com.example.grinhouseapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.List;

public class HomeViewModel extends ViewModel {

    MeasurementRepository measurementRepository;
    MutableLiveData<Measurement> measurementLiveData;

    public HomeViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }

    LiveData<List<Measurement>> getMeasurement()
    {
        return measurementRepository.getMeasurement();
    }

    Measurement getLastMeasurement(MeasurementType type)
    {
        for(int i = measurementRepository.getMeasurement().getValue().size()-1;i>=0;i--)
        {
            if(measurementRepository.getMeasurement().getValue().get(i).getMeasurementTypeEnum() == type)
            {
                return measurementRepository.getMeasurement().getValue().get(i);
            }
        }
        return null;
    }

    public void setMeasurementRepository()
    {
        measurementRepository.setMeasurement();
    }
}