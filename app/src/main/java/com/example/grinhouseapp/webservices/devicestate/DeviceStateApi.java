package com.example.grinhouseapp.webservices.devicestate;


import com.example.grinhouseapp.model.ACState;
import com.example.grinhouseapp.model.CarbonDioxideGeneratorState;
import com.example.grinhouseapp.model.HumidifierState;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DeviceStateApi {
    @GET("api/device-state/ac/latest")
    Call<ACState> getLatestACState();

    @GET("api/device-state/co2gen/latest")
    Call<CarbonDioxideGeneratorState> getLatestCo2GeneratorState();

    @GET("api/device-state/humidifier/latest")
    Call<HumidifierState> getLatestHumidifierState();



}