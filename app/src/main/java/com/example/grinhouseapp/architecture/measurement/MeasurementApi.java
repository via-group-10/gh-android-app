package com.example.grinhouseapp.architecture.measurement;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeasurementApi {
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
}
