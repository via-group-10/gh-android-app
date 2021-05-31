package com.example.grinhouseapp.webservices.profile;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.ThresholdProfile;
import com.example.grinhouseapp.webservices.ServiceGenerator;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepositoryTest {
    private List<ThresholdProfile> allThresholdProfiles;
    private ProfileRepository profileRepository;
    private ThresholdProfile thresholdProfile;

    @Before
    public void setUp()
    {
        allThresholdProfiles = new ArrayList<>();
        profileRepository = ProfileRepository.getInstance();
        thresholdProfile = new ThresholdProfile(55,"b",false,1,2,1,2,1,2,1);

    }

    @Test
    public void testSetAllProfiles() {
        ProfileApi profileApi = ServiceGenerator.getProfileApi();
        Call<List<ProfileResponse>> call = profileApi.getProfiles();
        call.enqueue(new Callback<List<ProfileResponse>>() {
            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                if(response.isSuccessful())
                {
                    List<ProfileResponse> profileResponses = response.body();
                    ArrayList<ThresholdProfile> profiles = new ArrayList<>();
                    for(ProfileResponse profileResponse : profileResponses)
                        profiles.add(profileResponse.getProfile());
                    allThresholdProfiles.addAll(profiles);
                }
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });

        profileRepository.setAllProfiles();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<ThresholdProfile> profiles = new ArrayList<>(Objects.requireNonNull(profileRepository.getAllProfiles().getValue()));
        Assert.assertEquals(allThresholdProfiles.size(), profiles.size());

    }

    @Test
    public void testCreateProfile() {
        profileRepository.createProfile(55,"b",false,1,2,1,2,1,2,1);

        profileRepository.setAllProfiles();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                for (ThresholdProfile profile: Objects.requireNonNull(profileRepository.getAllProfiles().getValue()))
                {
                    if (profile.equals(thresholdProfile))
                    {
                        Assert.assertNotNull(profile);
                    }
                }
    }

    @Test
    public void testDeleteProfile() {
        profileRepository.createProfile(55,"b",false,1,2,1,2,1,2,1);

        profileRepository.deleteProfile(55);
        profileRepository.setAllProfiles();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                for (ThresholdProfile profile: Objects.requireNonNull(profileRepository.getAllProfiles().getValue())
                ) {
                    if (profile.equals(thresholdProfile))
                    {
                        Assert.fail("delete profile");
                    }

                }


    }

    @Test
    public void testUpdateProfile() {
        thresholdProfile.setMaximumCarbonDioxide(49);
        profileRepository.updateProfile(thresholdProfile);
        profileRepository.setAllProfiles();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                for (ThresholdProfile profile: Objects.requireNonNull(profileRepository.getAllProfiles().getValue()))
                {
                    if (profile.getThresholdProfileId()==thresholdProfile.getThresholdProfileId())
                    {
                        if (profile.getMaximumCarbonDioxide()==49)
                        {
                            Assert.assertTrue("update profile",true);
                        }

                    }
                }
    }
}