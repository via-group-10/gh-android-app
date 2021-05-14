package com.example.grinhouseapp.ui.measurementFilter;

import android.text.format.Time;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.architecture.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;

import java.sql.Timestamp;
import java.util.List;

public class MeasurementFilterViewModel extends ViewModel {

    MeasurementRepository repository;

    public MeasurementFilterViewModel()
    {
        repository = repository.getInstance();
    }

    LiveData<List<Measurement>> getTemperatureFilterMeasurement()
    {
        return repository.getFilteredTemperatureMeasurementMutableData();
    }

    LiveData<List<Measurement>> getHumidityFilterMeasurement()
    {
        return repository.getFilteredHumidityMeasurementMutableData();
    }

    LiveData<List<Measurement>> getCarbonDioxideFilterMeasurement()
    {
        return repository.getFilteredCarbonDioxideMeasurementMutableData();
    }

    public void setMeasurementRepository(MeasurementType type, Timestamp from,Timestamp to )
    {
        if(type == MeasurementType.temperature)
            repository.setFilterTemperature(from,to);
        else if(type == MeasurementType.carbonDioxide)
            repository.setFilterCarbonDioxide(from,to);
        else
            repository.setFilterHumidity(from,to);
    }
}
