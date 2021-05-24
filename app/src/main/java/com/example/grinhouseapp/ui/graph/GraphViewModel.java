package com.example.grinhouseapp.ui.graph;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.graph.GraphRepository;
import com.example.grinhouseapp.model.Measurement;

import java.util.List;

public class GraphViewModel extends ViewModel {
    GraphRepository repository;

    public GraphViewModel(){repository = GraphRepository.getInstance();}
    // TODO: Implement the ViewModel

    LiveData<List<Measurement>> getMeasurements(int category)
    {
        if(category == 0)
            return repository.getTemperatureMeasurement();
        else if(category == 1)
            return repository.getHumidityMeasurement();
        return repository.getCarbonDioxideMeasurement();
    }

    public void setTemperatureMeasurements(String filter, int category)
    {
        if(category == 0)
            repository.setTemperatureMeasurement(filter);
        else if(category == 1)
            repository.setHumidityMeasurement(filter);
        else
            repository.setCarbonDioxideMeasurement(filter);
    }
}