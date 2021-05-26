package com.example.grinhouseapp.ui.editProfile;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.ui.addProfile.AddProfileViewModel;
import com.example.grinhouseapp.ui.profile.ProfileAdapter;
import com.example.grinhouseapp.webservices.profile.ProfileRepository;

import java.util.ArrayList;
import java.util.List;

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
        //ThresholdProfile profile = new ThresholdProfile(OldProfile.getProfileId(),profileName, false,minimumTemperature,maximumTemperature,
        //        minimumHumidity,maximumHumidity, minimumCarbonDioxide,maximumCarbonDioxide,1);
        profileRepository.updateProfile(OldProfile);
        System.out.println("Updating, profile name: "+OldProfile.getProfileName());
    }

}