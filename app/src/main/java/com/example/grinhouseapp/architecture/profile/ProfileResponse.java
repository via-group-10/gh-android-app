package com.example.grinhouseapp.architecture.profile;

import com.example.grinhouseapp.model.ThresholdProfile;

public class ProfileResponse {
    private int thresholdProfileId;
    private String profileName;
    private boolean active;
    private int minimumTemperature;
    private int maximumTemperature;
    private int minimumHumidity;
    private int maximumHumidity;
    private int minimumCarbonDioxide;
    private int maximumCarbonDioxide;
    private int greenhouseId;

    public ThresholdProfile getProfile()
    {
        return new ThresholdProfile(thresholdProfileId, profileName, active, minimumTemperature, maximumTemperature, minimumHumidity, maximumHumidity, minimumCarbonDioxide, maximumCarbonDioxide, greenhouseId);
    }
}
