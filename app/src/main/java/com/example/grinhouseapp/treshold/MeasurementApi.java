package com.example.grinhouseapp.treshold;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeasurementApi {
    @GET("{type}")
    Call<MeasurementResponse> getMeasurement(@Path("type") int type);
}
