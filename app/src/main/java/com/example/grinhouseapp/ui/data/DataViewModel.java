package com.example.grinhouseapp.ui.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.Measurement;
import com.example.grinhouseapp.webservices.MeasurementRepository;
import com.example.grinhouseapp.webservices.MeasurementType;

import java.util.List;

public class DataViewModel extends ViewModel {

    MeasurementRepository measurementRepository;

    public DataViewModel() {
        measurementRepository = MeasurementRepository.getInstance();
    }



}