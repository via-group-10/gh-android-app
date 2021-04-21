package com.example.grinhouseapp.treshold;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static MeasurementApi measurementApi;

    public static MeasurementApi getMeasurementApi()
    {
        if(measurementApi == null)
        {
            measurementApi = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/145f0376-626b-4eea-9851-19ae095924d6")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MeasurementApi.class);
        }
        return measurementApi;
    }
}
