package com.example.grinhouseapp.webservices.devicestate;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.model.ACState;
import com.example.grinhouseapp.webservices.ServiceGenerator;
import com.example.grinhouseapp.webservices.profile.ProfileResponse;
import com.example.grinhouseapp.model.CarbonDioxideGeneratorState;
import com.example.grinhouseapp.model.HumidifierState;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;


public class DeviceStateRepository {

    private static DeviceStateRepository instance;
    private final MutableLiveData<ACState> currentAcState;
    private final MutableLiveData<CarbonDioxideGeneratorState> currentCo2State;
    private final MutableLiveData<HumidifierState> currentHumidifierState;

    private DeviceStateRepository()
    {
        currentAcState = new MutableLiveData<>();
        currentCo2State = new MutableLiveData<>();
        currentHumidifierState = new MutableLiveData<>();
    }

    public static synchronized DeviceStateRepository getInstance()
    {
        if(instance == null)
            instance = new DeviceStateRepository();
        return instance;

    }

    public LiveData<ACState> getCurrentAcState() {
        //System.out.println("FFFFFFFFFFFFFFFFFFFFFF"+currentAcState.getValue().isCoolerOn());
        return currentAcState;
    }

    public LiveData<CarbonDioxideGeneratorState> getCurrentCo2State() {
        return currentCo2State;
    }

    public LiveData<HumidifierState> getCurrentHumidifierState() {
        return currentHumidifierState;
    }

    public void setACState()
    {
        DeviceStateApi deviceStateApi = ServiceGenerator.getDeviceStateApi();
        Call<ACState> call = deviceStateApi.getLatestACState();
        call.enqueue(new Callback<ACState>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<ACState> call, Response<ACState> response) {
                if(response.isSuccessful())
                {
                    System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGG"+response.body().getAcStateId()+response.body().isCoolerOn()+response.body().isHeaterOn());
                    ACState acState = response.body();
                    currentAcState.setValue(acState);
                    System.out.println("LLLLLLLLLLLLLLLLL"+currentAcState.getValue().isCoolerOn());
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<ACState> call, Throwable t) {
                Log.i("Retrofit getACState", "Something went wrong");
            }
        });

    }

    public void setCo2GeneratorState()
    {
        DeviceStateApi deviceStateApi = ServiceGenerator.getDeviceStateApi();
        Call<CarbonDioxideGeneratorState> call = deviceStateApi.getLatestCo2GeneratorState();
        call.enqueue(new Callback<CarbonDioxideGeneratorState>() {
            @Override
            public void onResponse(Call<CarbonDioxideGeneratorState> call, Response<CarbonDioxideGeneratorState> response) {
                if(response.isSuccessful())
                {
                    CarbonDioxideGeneratorState co2GeneratorState = response.body();
                    currentCo2State.setValue(co2GeneratorState);
                }
            }

            @Override
            public void onFailure(Call<CarbonDioxideGeneratorState> call, Throwable t) {
                Log.i("Retrofit getCo2State", "Something went wrong");
            }
        });
    }

    public void setHumidifierState()
    {
        DeviceStateApi deviceStateApi = ServiceGenerator.getDeviceStateApi();
        Call<HumidifierState> call = deviceStateApi.getLatestHumidifierState();
        call.enqueue(new Callback<HumidifierState>() {
            @Override
            public void onResponse(Call<HumidifierState> call, Response<HumidifierState> response) {
                if(response.isSuccessful())
                {
                    HumidifierState humidifierState = response.body();
                    currentHumidifierState.setValue(humidifierState);
                }
            }

            @Override
            public void onFailure(Call<HumidifierState> call, Throwable t) {
                Log.i("Retrofit ", "Something went wrong-getHumidifierState");
            }
        });
    }
}