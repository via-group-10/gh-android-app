package com.example.grinhouseapp.webservices.profile;

import com.example.grinhouseapp.model.ThresholdProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfileApi {
    @GET("api/profile")
    Call<List<ProfileResponse>> getProfiles();
    @GET("api/profile/current")
    Call<ProfileResponse> getCurrentProfile();
    @DELETE("api/profile/{id}")
    Call<ProfileResponse> deleteProfile(@Path("id") int id);
    @POST("api/profile")
    Call<ProfileResponse> createProfile(@Body ThresholdProfile profile);
    @PUT("api/profile")
    Call<ProfileResponse> putProfile(@Body ThresholdProfile profile);
}
