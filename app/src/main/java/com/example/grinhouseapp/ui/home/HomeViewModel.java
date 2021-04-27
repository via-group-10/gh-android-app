package com.example.grinhouseapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    MeasurementRepository measurementRepository;

    public HomeViewModel()
    {
        measurementRepository = MeasurementRepository.getInstance();
    }


    public LiveData<Measurement> getTemperature(){
        measurementRepository.getLatestMeasurement(MeasurementType.temperature);
        return measurementRepository.getMeasurement();
    }


    public LiveData<Measurement> getHumidity(){
        measurementRepository.getLatestMeasurement(MeasurementType.humidity);
        return measurementRepository.getMeasurement();
    }

    public LiveData<Measurement> getCarbonDioxide()
    {
        measurementRepository.getLatestMeasurement(MeasurementType.carbonDioxide);
        return measurementRepository.getMeasurement();
    }



    public LiveData<Measurement> getMeasurement()
    {
        switch (measurementRepository.getMeasurement().getValue().getMeasurementTypeEnum())
        {
            default:
            case temperature:measurementRepository.getLatestMeasurement(MeasurementType.temperature);
            break;
            case humidity:measurementRepository.getLatestMeasurement(MeasurementType.humidity);
            break;
            case carbonDioxide: measurementRepository.getLatestMeasurement(MeasurementType.carbonDioxide);
                break;
        }
        return measurementRepository.getMeasurement();

    }

    public LiveData<String> getText() {
        return mText;
    }
}