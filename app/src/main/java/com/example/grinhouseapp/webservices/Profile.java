package com.example.grinhouseapp.webservices;

public class Profile {
    private String profileName;
    private float minTempValue;
    private float maxTempValue;
    private float minHumValue;
    private float maxHumValue;
    private float minCdValue;
    private float maxCdValue;

    public Profile(String profileName, float minTempValue, float maxTempValue, float minHumValue, float maxHumValue, float minCdValue, float maxCdValue)
    {
        this.profileName = profileName;
        this.minTempValue = minTempValue;
    }
}
