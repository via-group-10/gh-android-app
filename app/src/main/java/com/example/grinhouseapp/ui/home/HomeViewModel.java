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

    public void setMeasurementRepository()
    {
        measurementRepository.setLatestMeasurements();
    }

    /** DATABASE **/
    public LiveData<List<Measurement>> getAllMeasurementsDB()
    {
        return databaseRepository.getAllMeasurements();
    }

    public void insertMeasurement(Measurement measurement)
    {
        insertMeasurement(measurement);
    }
}