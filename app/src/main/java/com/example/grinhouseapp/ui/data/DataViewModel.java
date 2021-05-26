package com.example.grinhouseapp.ui.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.database.DatabaseRepository;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    MeasurementRepository measurementRepository;
    DatabaseRepository databaseRepository;

    public DataViewModel(Application app)
    {
        super(app);
        measurementRepository = MeasurementRepository.getInstance();
        databaseRepository = DatabaseRepository.getInstance(app);
    }

    public LiveData<List<Measurement>> getMeasurement(MeasurementType measurementType)
    {
        if(measurementType == MeasurementType.temperature)
            return measurementRepository.getTemperatureMeasurementMutableData();
        else if(measurementType == MeasurementType.humidity)
            return measurementRepository.getHumidityMeasurementMutableData();
        else
            return measurementRepository.getCarbonDioxideMeasurementMutableData();
    }

    public void setMeasurementRepository(MeasurementType type)
    {
        if(type == MeasurementType.temperature)
            measurementRepository.setTemperatureMeasurements();
        else if(type == MeasurementType.carbonDioxide)
            measurementRepository.setCarbonDioxideMeasurement();
        else
            measurementRepository.setHumidityMeasurements();
    }

    public LiveData<List<Measurement>> getMeasurementsDB(MeasurementType measurementType)
    {
        return databaseRepository.getAllMeasurements(measurementType);
    }
}