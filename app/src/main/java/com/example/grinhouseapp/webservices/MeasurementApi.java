package com.example.grinhouseapp.webservices;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeasurementApi {
    /****************
     * Measurements *
     ****************/
    @GET("api/measurement")
    Call<List<MeasurementResponse>> getAllMeasurements();
    @GET("api/measurement/latest")
    Call<List<MeasurementResponse>> getLatestMeasurements();
    @GET("api/measurement/temperature")
    Call<List<MeasurementResponse>> getTemperatureMeasurement();
    @GET("api/measurement/humidity")
    Call<List<MeasurementResponse>> getHumidityMeasurement();
    @GET("api/measurement/carbon-dioxide")
    Call<List<MeasurementResponse>> getCarbonDioxideMeasurement();

    /************
     * Profiles *
     ************/
    @GET("api/profile")
    Call<List<ThresholdProfile>> getProfiles();
    @GET("api/profile/current")
    Call<ThresholdProfile> getCurrentProfile();
    /*@DELETE("api/profile/{id}")
    @POST("api/profile")
    @PUT("api/profile")*/
}
