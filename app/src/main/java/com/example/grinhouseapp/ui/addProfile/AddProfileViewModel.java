package com.example.grinhouseapp.ui.addProfile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.profile.ProfileRepository;
import com.example.grinhouseapp.model.ThresholdProfile;

public class AddProfileViewModel extends ViewModel {
    private ProfileRepository profileRepository;

    public AddProfileViewModel()
    {
        profileRepository = ProfileRepository.getInstance();
    }

    public LiveData<ThresholdProfile> getCurrentProfile()
    {
        return profileRepository.getCurrentProfile();
    }


    public void addNewProfile(String profileName, int minimumTemperature,
                              int maximumTemperature, int minimumHumidity, int maximumHumidity,
                              int minimumCarbonDioxide, int maximumCarbonDioxide)
    {
        int num =(int) (Math.random() * 9 + 1) * 100000;
        //profileRepository.createProfile(num,profileName, false,minimumTemperature,maximumTemperature,
        //        minimumHumidity,maximumHumidity, minimumCarbonDioxide,maximumCarbonDioxide,getCurrentProfile().getValue().getGreenhouseId());
        profileRepository.createProfile(num,profileName, false,minimumTemperature,maximumTemperature,
                minimumHumidity,maximumHumidity, minimumCarbonDioxide,maximumCarbonDioxide,1);
    }
}
