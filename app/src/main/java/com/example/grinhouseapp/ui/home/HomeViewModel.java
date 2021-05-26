package com.example.grinhouseapp.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.database.DatabaseRepository;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    MeasurementRepository measurementRepository;
    DatabaseRepository databaseRepository;

    public HomeViewModel(Application app)
    {
        super(app);
        measurementRepository = MeasurementRepository.getInstance();
        databaseRepository = DatabaseRepository.getInstance(app);
    }

    LiveData<List<Measurement>> getMeasurement()
    {
        return measurementRepository.getLatestMeasurements();
    }

    public LiveData<List<Measurement>> getTopMeasurement(MeasurementType measurementType)
    {
        if(measurementType == MeasurementType.temperature)
            return measurementRepository.getTopTemperatureMeasurements();
        else if(measurementType == MeasurementType.humidity)
            return measurementRepository.getTopHumidityMeasurements();
        else
            return measurementRepository.getTopCarbonDioxideMeasurements();
    }

    public void setTopMeasurement(MeasurementType measurementType, int count)
    {
        if(measurementType == MeasurementType.temperature)
            measurementRepository.setTopTemperatureMeasurements(count);
        else if(measurementType == MeasurementType.humidity)
            measurementRepository.setTopHumidityMeasurements(count);
        else
            measurementRepository.setTopCarbonDioxideMeasurements(count);
    }

    public void setMeasurementRepository()
    {
        measurementRepository.setLatestMeasurements();
    }

    /** DATABASE **/
    public LiveData<List<Measurement>> getAllMeasurementsDB(MeasurementType measurementType)
    {
        return databaseRepository.getAllMeasurements(measurementType);
    }

    public void insertMeasurement(List<Measurement> measurements)
    {
        databaseRepository.insertMeasurement(measurements);
    }
}