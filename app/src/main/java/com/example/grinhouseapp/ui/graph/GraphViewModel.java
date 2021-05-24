package com.example.grinhouseapp.ui.graph;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.webservices.graph.GraphRepository;
import com.example.grinhouseapp.webservices.measurement.MeasurementRepository;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

public class GraphViewModel extends ViewModel {

    GraphRepository graphRepository;

    public GraphViewModel()
    {
        graphRepository = GraphRepository.getInstance();
    }

    public LiveData<List<Measurement>> getTemperatureGraphMeasurement()
    {
        return graphRepository.getTemperatureMeasurement();
    }
    LiveData<List<Measurement>> getHumidityMeasurement()
    {
        return graphRepository.getHumidityMeasurement();
    }
    LiveData<List<Measurement>> getCarbonDioxideMeasurement()
    {
        return graphRepository.getCarbonDioxideMeasurement();
    }


    public void setMeasurementRepository(MeasurementType type, String filter)
    {
        if(type == MeasurementType.temperature)
            graphRepository.setTemperatureMeasurement(filter);
        else if(type == MeasurementType.carbonDioxide)
            graphRepository.setCarbonDioxideMeasurement(filter);
        else
            graphRepository.setHumidityMeasurement(filter);
    }
}