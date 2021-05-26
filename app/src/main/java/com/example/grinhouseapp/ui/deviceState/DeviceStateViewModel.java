package com.example.grinhouseapp.ui.deviceState;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.devicestate.DeviceStateRepository;
import com.example.grinhouseapp.model.ACState;
import com.example.grinhouseapp.model.CarbonDioxideGeneratorState;
import com.example.grinhouseapp.model.HumidifierState;


public class DeviceStateViewModel extends ViewModel {
    DeviceStateRepository deviceStateRepository;

    public DeviceStateViewModel()
    {
        deviceStateRepository = DeviceStateRepository.getInstance();
    }

    public LiveData<ACState> getCurrentAcState()
    {
        Log.i("current_state", "getting current state..");
        return deviceStateRepository.getCurrentAcState();

    }

    public LiveData<CarbonDioxideGeneratorState> getCurrentCo2GeneratorState()
    {
        return deviceStateRepository.getCurrentCo2State();
    }

    public LiveData<HumidifierState> getCurrentHumidifierState()
    {
        return deviceStateRepository.getCurrentHumidifierState();
    }

    public void setACState()
    {
        deviceStateRepository.setACState();
    }

    public void setCo2GeneratorState()
    {
        deviceStateRepository.setCo2GeneratorState();
    }

    public void setHumidifierState()
    {
        deviceStateRepository.setHumidifierState();
    }
}