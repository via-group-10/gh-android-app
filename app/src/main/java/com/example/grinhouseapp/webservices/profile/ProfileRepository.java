package com.example.grinhouseapp.webservices.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.grinhouseapp.webservices.ServiceGenerator;
import com.example.grinhouseapp.model.ThresholdProfile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static ProfileRepository instance;
    private final MutableLiveData<List<ThresholdProfile>> allProfilesMutableData;
    private final MutableLiveData<ThresholdProfile> currentProfileMutableData;

    private ProfileRepository()
    {
        allProfilesMutableData = new MutableLiveData<>();
        currentProfileMutableData = new MutableLiveData<>();
    }

    public static synchronized ProfileRepository getInstance()
    {
        if(instance == null)
            instance = new ProfileRepository();
        return instance;
    }

    public LiveData<List<ThresholdProfile>> getAllProfiles()
    {
        return allProfilesMutableData;
    }

    public MutableLiveData<ThresholdProfile> getCurrentProfile() {
        return currentProfileMutableData;
    }

    public void setAllProfiles()
    {
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
                    allProfilesMutableData.setValue(profiles);
                }
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void setCurrentProfile()
    {
        ProfileApi profileApi = ServiceGenerator.getProfileApi();
        Call<ProfileResponse> call = profileApi.getCurrentProfile();
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if(response.isSuccessful())
                {
                    currentProfileMutableData.setValue(response.body().getProfile());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public void createProfile(int profileId, String profileName, boolean active, int minimumTemperature,
                              int maximumTemperature, int minimumHumidity, int maximumHumidity,
                              int minimumCarbonDioxide, int maximumCarbonDioxide, int greenhouseId)
    {
        ProfileApi profileApi = ServiceGenerator.getProfileApi();
        ThresholdProfile profile = new ThresholdProfile(profileId, profileName, active, minimumTemperature,
                maximumTemperature, minimumHumidity, maximumHumidity, minimumCarbonDioxide, maximumCarbonDioxide, greenhouseId);
        Call<ProfileResponse> call = profileApi.createProfile(profile);
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if(response.isSuccessful())
                {
                    //allProfilesMutableData.getValue().add(profile);
                    Log.i("Post profile",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.i("Retrofit", "CREATE PROFILE Something went wrong");
            }
        });
    }

    public void deleteProfile(int id) {
        ProfileApi profileApi = ServiceGenerator.getProfileApi();
        Call<ProfileResponse> call = profileApi.deleteProfile(id);
        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    //for (int i=0; i<allProfilesMutableData.getValue().size(); i++)
                    //{
                    //    if (allProfilesMutableData.getValue().get(i).getProfileId()==id)
                    //    {
                    //        allProfilesMutableData.getValue().remove(allProfilesMutableData.getValue().get(i));
                    //        break;
                    //    }
                    //}
                    Log.i("Delete profile", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.i("Retrofit", "DELETE PROFILE Something went wrong");
            }
        });
    }
}
