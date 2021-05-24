package com.example.grinhouseapp.webservices.graph;

import com.example.grinhouseapp.webservices.measurement.MeasurementResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GraphApi {
    @GET("api/graph/temperature/{filter}")
    Call<List<MeasurementResponse>> getTemperatureGraphData(@Path("filter") String filter);
    @GET("api/graph/humidity/{filter}")
    Call<List<MeasurementResponse>> getHumidityGraphData(@Path("filter") String filter);
    @GET("api/graph/carbon-dioxide/{filter}")
    Call<List<MeasurementResponse>> getCarbonDioxideGraphData(@Path("filter") String filter);
}
