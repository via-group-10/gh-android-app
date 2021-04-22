package com.example.grinhouseapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    MeasurementRepository measurementRepository;

    public HomeViewModel()
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

    public LiveData<String> getText() {
        return mText;
    }
}