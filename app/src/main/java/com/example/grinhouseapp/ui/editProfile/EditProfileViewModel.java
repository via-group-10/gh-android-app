package com.example.grinhouseapp.ui.editProfile;
import androidx.lifecycle.ViewModel;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.webservices.profile.ProfileRepository;


public class  EditProfileViewModel   extends ViewModel {
    private ProfileRepository profileRepository;
    public static ThresholdProfile OldProfile;

    public EditProfileViewModel()
    {
        profileRepository = ProfileRepository.getInstance();
    }

    public void updateProfile(String profileName, int minimumTemperature,
                              int maximumTemperature, int minimumHumidity, int maximumHumidity,
                              int minimumCarbonDioxide, int maximumCarbonDioxide)
    {
        OldProfile.setProfileName(profileName);
        OldProfile.setMinimumTemperature(minimumTemperature);
        OldProfile.setMaximumTemperature(maximumTemperature);
        OldProfile.setMinimumHumidity(minimumHumidity);
        OldProfile.setMaximumHumidity(maximumHumidity);
        OldProfile.setMinimumCarbonDioxide(minimumCarbonDioxide);
        OldProfile.setMaximumCarbonDioxide(maximumCarbonDioxide);

        profileRepository.updateProfile(OldProfile);
        System.out.println("Updating, profile name: "+OldProfile.getProfileName());
    }

}