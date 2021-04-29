package com.example.grinhouseapp.model;

public class ThresholdProfile {
    private String profileName;
    private float minTempValue;
    private float maxTempValue;
    private float minHumValue;
    private float maxHumValue;
    private float minCdValue;
    private float maxCdValue;

    public ThresholdProfile(String profileName, float minTempValue, float maxTempValue, float minHumValue, float maxHumValue, float minCdValue, float maxCdValue)
    {
        this.profileName = profileName;
        this.minTempValue = minTempValue;
    }
}
