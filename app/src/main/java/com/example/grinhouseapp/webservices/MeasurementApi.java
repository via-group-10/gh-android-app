package com.example.grinhouseapp.webservices;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeasurementApi {
   // @GET("{type}")
   // Call<MeasurementResponse> getMeasurement(@Path("type") MeasurementType type);
    @GET("measurements")
    Call<List<MeasurementResponse>> getAllMeasurements();
}
