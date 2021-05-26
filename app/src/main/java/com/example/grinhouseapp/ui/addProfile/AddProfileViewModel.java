package com.example.grinhouseapp.ui.addProfile;

import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.profile.ProfileRepository;
import com.example.grinhouseapp.model.ThresholdProfile;

public class AddProfileViewModel extends ViewModel {
    private ProfileRepository profileRepository;

    public AddProfileViewModel()
    {
        profileRepository = ProfileRepository.getInstance();
    }



    public void addNewProfile(String profileName, int minimumTemperature,
                              int maximumTemperature, int minimumHumidity, int maximumHumidity,
                              int minimumCarbonDioxide, int maximumCarbonDioxide)
    {
        int num =(int) (Math.random() * 9 + 1) * 100000;
        for (int i=0;i<profileRepository.getAllProfiles().getValue().size();i++)
        {
            if (getThresholdProfileById(num)!=null)
            {
                num++;
            }
        }
        profileRepository.createProfile(num,profileName, false,minimumTemperature,maximumTemperature,
                minimumHumidity,maximumHumidity, minimumCarbonDioxide,maximumCarbonDioxide,1);
    }
    public ThresholdProfile getThresholdProfileById(int id)
    {
        for (int i=0;i<profileRepository.getAllProfiles().getValue().size();i++) {
            if (profileRepository.getAllProfiles().getValue().get(i).getThresholdProfileId()==id)
            {
                return profileRepository.getAllProfiles().getValue().get(i);
            }
        }
        return null;

    }
}
