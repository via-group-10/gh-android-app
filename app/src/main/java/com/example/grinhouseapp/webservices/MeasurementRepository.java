package com.example.grinhouseapp.webservices;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MeasurementRepository {
    private static MeasurementRepository instance;
    private final MutableLiveData<Measurement> measurementMutableLiveData;

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

    public LiveData<Measurement> getMeasurement()
    {
        return  measurementMutableLiveData;
    }

    public void  setMeasurement(MeasurementType type)
    {
        MeasurementApi measurementApi = ServiceGenerator.getMeasurementApi();
        Call<MeasurementResponse> call = measurementApi.getMeasurement(type);
        call.enqueue(new Callback<MeasurementResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<MeasurementResponse> call, Response<MeasurementResponse> response) {
                if(response.isSuccessful())
                    measurementMutableLiveData.setValue(response.body().getMeasurement());
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<MeasurementResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }
}
