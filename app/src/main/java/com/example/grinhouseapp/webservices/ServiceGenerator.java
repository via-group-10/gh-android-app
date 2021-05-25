package com.example.grinhouseapp.webservices;

import com.example.grinhouseapp.webservices.graph.GraphApi;
import com.example.grinhouseapp.webservices.greenhouse.GreenhouseApi;
import com.example.grinhouseapp.webservices.measurement.MeasurementApi;
import com.example.grinhouseapp.webservices.profile.ProfileApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static MeasurementApi measurementApi;
    private static ProfileApi profileApi;
    private static GraphApi graphApi;
    private static GreenhouseApi greenhouseApi;

    public static MeasurementApi getMeasurementApi()
    {
        if(measurementApi == null)
        {
            measurementApi = new Retrofit.Builder()
                    .baseUrl("http://20.52.3.144:8080/")
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
                    .baseUrl("http://20.52.3.144:8080/")
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
                    .baseUrl("http://20.52.3.144:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GraphApi.class);
        }
        return graphApi;
    }

    public static GreenhouseApi getGreenhouseApi()
    {
        if(greenhouseApi == null)
        {
            greenhouseApi = new Retrofit.Builder().
                    baseUrl("http://20.52.3.144:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GreenhouseApi.class);
        }
        return greenhouseApi;
    }
}
