package com.example.grinhouseapp.ui.measurementFilter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.architecture.measurement.MeasurementRepository;

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

    public void setMeasurementRepository(MeasurementType type)
    {
        if(type == MeasurementType.temperature)
            measurementRepository.setFilterTemperature();
        else if(type == MeasurementType.carbonDioxide)
            measurementRepository.setFilterCarbonDioxide();
        else
            measurementRepository.setFilterHumidity();
    }
}
