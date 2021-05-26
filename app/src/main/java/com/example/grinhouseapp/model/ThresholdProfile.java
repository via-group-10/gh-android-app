package com.example.grinhouseapp.model;

public class ThresholdProfile {
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

    public int getThresholdProfileId() {
        return thresholdProfileId;
    }

    public void setThresholdProfileId(int thresholdProfileId) {
        this.thresholdProfileId = thresholdProfileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(int minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(int maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public int getMinimumHumidity() {
        return minimumHumidity;
    }

    public void setMinimumHumidity(int minimumHumidity) {
        this.minimumHumidity = minimumHumidity;
    }

    public int getMaximumHumidity() {
        return maximumHumidity;
    }

    public void setMaximumHumidity(int maximumHumidity) {
        this.maximumHumidity = maximumHumidity;
    }

    public int getMinimumCarbonDioxide() {
        return minimumCarbonDioxide;
    }

    public void setMinimumCarbonDioxide(int minimumCarbonDioxide) {
        this.minimumCarbonDioxide = minimumCarbonDioxide;
    }

    public int getMaximumCarbonDioxide() {
        return maximumCarbonDioxide;
    }

    public void setMaximumCarbonDioxide(int maximumCarbonDioxide) {
        this.maximumCarbonDioxide = maximumCarbonDioxide;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public ThresholdProfile(int thresholdProfileId, String profileName, boolean active, int minimumTemperature, int maximumTemperature, int minimumHumidity, int maximumHumidity, int minimumCarbonDioxide, int maximumCarbonDioxide, int greenhouseId) {
        this.thresholdProfileId = thresholdProfileId;
        this.profileName = profileName;
        this.active = active;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.minimumHumidity = minimumHumidity;
        this.maximumHumidity = maximumHumidity;
        this.minimumCarbonDioxide = minimumCarbonDioxide;
        this.maximumCarbonDioxide = maximumCarbonDioxide;
        this.greenhouseId = greenhouseId;


    }
}
