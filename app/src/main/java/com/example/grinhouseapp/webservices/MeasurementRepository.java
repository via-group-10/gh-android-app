package com.example.grinhouseapp.webservices;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepository {
    private static MeasurementRepository instance;
    private final MutableLiveData<List<Measurement>> measurementMutableLiveData;

    private MeasurementRepository()
    {
        measurementMutableLiveData = new MutableLiveData<>();
    }

    public static synchronized MeasurementRepository getInstance()
    {
        if(instance == null)
            instance = new MeasurementRepository();
        return instance;
    }

    public LiveData<List<Measurement>> getMeasurement()
    {
        return  measurementMutableLiveData;
    }

    public void  setMeasurement()
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getAllMeasurements();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if(response.isSuccessful()) {
                    Log.i("Ërror", "this is not working");
                    List<MeasurementResponse> measurementResponses = response.body();
                    ArrayList<Measurement> measurements = new ArrayList<>();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        measurements.add(measurementResponse.getMeasurement());
                    }
                    measurementMutableLiveData.setValue(measurements);
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }
}
