package com.example.grinhouseapp.treshold;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static MeasurementApi measurementApi;

    public static MeasurementApi getMeasurementApi()
    {
        if(measurementApi == null)
        {
            measurementApi = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/62455ef4-7fa5-4d56-9631-e5d876e8eaee/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MeasurementApi.class);
        }
        return measurementApi;
    }
}
