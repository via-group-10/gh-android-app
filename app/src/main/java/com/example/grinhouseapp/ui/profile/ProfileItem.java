package com.example.grinhouseapp.ui.profile;

public class ProfileItem {

    private String profileName;
    private float valueCO2;
    private float valueHumidity;
    private float valueTemperature;


    public ProfileItem(String profileName, float valueCO2, float valueHumidity, float valueTemperature) {
        this.profileName = profileName;
        this.valueCO2 = valueCO2;
        this.valueHumidity = valueHumidity;
        this.valueTemperature = valueTemperature;
    }

    public String getProfileName() {
        return profileName;
    }

    public float getValueCO2() {
        return valueCO2;
    }

    public float getValueHumidity() {
        return valueHumidity;
    }

    public float getValueTemperature() {
        return valueTemperature;
    }
}
