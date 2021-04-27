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
    private final MutableLiveData<Measurement> measurementMutableLiveData;
    private final MutableLiveData<List<Measurement>> measurementList;

    private MeasurementRepository()
    {
        measurementMutableLiveData = new MutableLiveData<>();
        measurementList = new MutableLiveData<>();
    }

    public static synchronized MeasurementRepository getInstance()
    {
        if(instance == null)
            instance = new MeasurementRepository();
        return instance;
    }

    public LiveData<Measurement> getMeasurement()
    {
        return  measurementMutableLiveData;
    }

    public MutableLiveData<List<Measurement>> getMeasurementList() {
        return measurementList;
    }

    public void  getMeasurements(MeasurementType type) {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<List<MeasurementResponse>> call = measurementApi.getAllMeasurements();
        call.enqueue(new Callback<List<MeasurementResponse>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                if (response.isSuccessful()) {
                    List<MeasurementResponse> measurementResponses = response.body();
                    for (MeasurementResponse measurementResponse : measurementResponses) {
                        List<Measurement> measurements = new ArrayList<>();
                        if (measurementResponse.getMeasurement().getMeasurementTypeEnum()==type)
                        {
                            measurements.add(measurementResponse.getMeasurement());
                        }
                        measurementList.setValue(measurements);
                        //measurementMutableLiveData.setValue(measurementResponse.getMeasurement(type));
                    }
                } else {

                    System.out.println("Not good !!!" + response.code());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<MeasurementResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong", t);
            }
        });
    }

        public void getLatestMeasurement(MeasurementType type)
        {
            MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
            Call<List<MeasurementResponse>> call = measurementApi.getAllMeasurements();
            call.enqueue(new Callback<List<MeasurementResponse>>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<List<MeasurementResponse>> call, Response<List<MeasurementResponse>> response) {
                    if (response.isSuccessful()) {
                        List<MeasurementResponse> measurementResponses = response.body();
                        for (MeasurementResponse measurementResponse : measurementResponses) {
                            if (measurementResponse.getMeasurement().getMeasurementTypeEnum()==type)
                            {

                                    measurementMutableLiveData.setValue(measurementResponse.getMeasurement());

                            }

                        }
                    } else {

                        System.out.println("Not good !!!" + response.code());
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
