package com.example.grinhouseapp.webservices.greenhouse;

import com.example.grinhouseapp.model.Credentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GreenhouseApi {
    @POST("api/greenhouse")
    Call<GreenhouseResponse> login(@Body Credentials credentials);
}
