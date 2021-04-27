package com.example.grinhouseapp.webservices;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeasurementApi {
    @GET("{type}")
    Call<MeasurementResponse> getMeasurement(@Path("type") MeasurementType type);
    @GET("4d74dded-3341-468b-bb16-9ce921723b97/") //measurements
    Call<List<MeasurementResponse>> getAllMeasurements();
}
