package com.example.grinhouseapp.webservices;

import com.example.grinhouseapp.webservices.devicestate.DeviceStateApi;
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
    private static DeviceStateApi deviceStateApi;

    private static String url = "http://20.52.3.144:8080/";

    public static MeasurementApi getMeasurementApi()
    {
        if(measurementApi == null)
        {
            measurementApi = new Retrofit.Builder()
                    .baseUrl(url)
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
                    .baseUrl(url)
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
                    .baseUrl(url)
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
            greenhouseApi = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GreenhouseApi.class);
        }
        return greenhouseApi;
    }

    public static DeviceStateApi getDeviceStateApi()
    {
        if (deviceStateApi == null)
        {
            deviceStateApi = new Retrofit.Builder()
                    .baseUrl("http://20.52.3.144:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(DeviceStateApi.class);
        }
        return deviceStateApi;
    }
}
