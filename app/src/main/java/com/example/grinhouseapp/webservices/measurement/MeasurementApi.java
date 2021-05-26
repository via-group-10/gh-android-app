package com.example.grinhouseapp.webservices.measurement;


import java.sql.Timestamp;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MeasurementApi {
    @GET("api/measurement/latest")
    Call<List<MeasurementResponse>> getLatestMeasurements();
    @GET("api/measurement/temperature")
    Call<List<MeasurementResponse>> getTopTemperatureMeasurements(@Query("top") int count);
    @GET("api/measurement/humidity")
    Call<List<MeasurementResponse>> getTopHumidityMeasurements(@Query("top") int count);
    @GET("api/measurement/carbon-dioxide")
    Call<List<MeasurementResponse>> getTopCarbonDioxideMeasurements(@Query("top") int count);

    /** FILTERING **/
    @GET("api/measurement/temperature/range")
    Call<List<MeasurementResponse>> getFilteredTemperature(@Query("from")Timestamp from, @Query("to") Timestamp to);
    @GET("api/measurement/humidity/range")
    Call<List<MeasurementResponse>> getFilteredHumidity(@Query("from")Timestamp from, @Query("to") Timestamp to);
    @GET("api/measurement/carbon-dioxide/range")
    Call<List<MeasurementResponse>> getFilteredCarbonDioxide(@Query("from")Timestamp from, @Query("to") Timestamp to);
}
