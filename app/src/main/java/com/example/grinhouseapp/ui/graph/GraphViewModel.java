package com.example.grinhouseapp.ui.graph;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.architecture.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

public class GraphViewModel extends ViewModel {
    MeasurementRepository measurementRepository;

    public GraphViewModel(){measurementRepository = MeasurementRepository.getInstance();}
    // TODO: Implement the ViewModel

    LiveData<List<Measurement>> getTemperatureMeasurement()
    {
        return measurementRepository.getTemperatureMeasurementMutableData();
    }
    LiveData<List<Measurement>> getHumidityMeasurement()
    {
        return measurementRepository.getHumidityMeasurementMutableData();
    }
    LiveData<List<Measurement>> getCarbonDioxideMeasurement()
    {
        return measurementRepository.getCarbonDioxideMeasurementMutableData();
    }

    List<Measurement> liveDataToList(MeasurementType type)
    {
        if(type == MeasurementType.temperature)
            return measurementRepository.getTemperatureMeasurementMutableData().getValue();
        else if(type == MeasurementType.carbonDioxide)
            return measurementRepository.getCarbonDioxideMeasurementMutableData().getValue();
        else
            return measurementRepository.getHumidityMeasurementMutableData().getValue();
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
}