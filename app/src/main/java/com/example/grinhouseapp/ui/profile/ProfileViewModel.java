package com.example.grinhouseapp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.grinhouseapp.webservices.profile.ProfileRepository;
import com.example.grinhouseapp.model.ThresholdProfile;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    ProfileRepository profileRepository;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is profile fragment");
        profileRepository = ProfileRepository.getInstance();
    }

    public void setProfileRepository()
    {
        profileRepository.setAllProfiles();
    }

    public LiveData<List<ThresholdProfile>> getAllProfiles()
    {
        return profileRepository.getAllProfiles();
    }

    public List<ThresholdProfile> getAllProfilesInList()
    {
        return profileRepository.getAllProfiles().getValue();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void deleteProfile(int id)
    {
        profileRepository.deleteProfile(id);
    }
}