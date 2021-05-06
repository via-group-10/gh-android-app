package com.example.grinhouseapp.architecture;

import com.example.grinhouseapp.architecture.graph.GraphApi;
import com.example.grinhouseapp.architecture.measurement.MeasurementApi;
import com.example.grinhouseapp.architecture.profile.ProfileApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static MeasurementApi measurementApi;
    private static ProfileApi profileApi;
    private static GraphApi graphApi;

    public static MeasurementApi getMeasurementApi()
    {
        if(measurementApi == null)
        {
            measurementApi = new Retrofit.Builder()
                    .baseUrl("http://ajajaj.serveminecraft.net:8080/")
//                    .baseUrl("http://192.168.87.100:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MeasurementApi.class);
        }
        return measurementApi;
    }

    public static ProfileApi getProfileApi()
    {
        if(profileApi == null)
        {
            profileApi = new Retrofit.Builder()
                    .baseUrl("http://ajajaj.serveminecraft.net:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProfileApi.class);
        }
        return profileApi;
    }

    public static GraphApi getGraphApi()
    {
        if(graphApi == null)
        {
            graphApi = new Retrofit.Builder()
                    .baseUrl("http://ajajaj.serveminecraft.net:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GraphApi.class);
        }
        return graphApi;
    }
}
