package com.example.grinhouseapp.webservices.graph;

import com.example.grinhouseapp.webservices.measurement.MeasurementResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GraphApi {
    @GET("api/graph/temperature")
    Call<List<MeasurementResponse>> getTemperatureGraphData(@Query("filter") String filter);
    @GET("api/graph/humidity")
    Call<List<MeasurementResponse>> getHumidityGraphData(@Query("filter") String filter);
    @GET("api/graph/carbon-dioxide")
    Call<List<MeasurementResponse>> getCarbonDioxideGraphData(@Query("filter") String filter);
}
