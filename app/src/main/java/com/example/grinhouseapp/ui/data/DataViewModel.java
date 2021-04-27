package com.example.grinhouseapp.ui.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.List;

public class DataViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    MeasurementRepository measurementRepository;

    public DataViewModel() {
        measurementRepository = MeasurementRepository.getInstance();
    }

    public LiveData<List<Measurement>> getTemperatures() {
        measurementRepository.getMeasurements(MeasurementType.temperature);
        return measurementRepository.getMeasurementList();
    }

    public LiveData<List<Measurement>> getHumidities()
    {
        measurementRepository.getMeasurements(MeasurementType.humidity);
        return measurementRepository.getMeasurementList();
    }

    public LiveData<List<Measurement>> getCarbonDioxides() {
        measurementRepository.getMeasurements(MeasurementType.carbonDioxide);
        return measurementRepository.getMeasurementList();
    }





    public LiveData<String> getText() {
        return mText;
    }
}