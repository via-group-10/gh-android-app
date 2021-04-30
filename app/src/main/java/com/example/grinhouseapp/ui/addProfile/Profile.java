package com.example.grinhouseapp.ui.addProfile;

public class Profile {
    private String profileName;
    private float temperatureLow;
    private float temperatureHight;
    private float co2Low;
    private float co2High;
    private float humidityLow;
    private float humidityHigh;

    public Profile(String profileName, float temperatureLow, float temperatureHight, float co2Low, float co2High, float humidityLow, float humidityHigh) {
        this.profileName = profileName;
        this.temperatureLow = temperatureLow;
        this.temperatureHight = temperatureHight;
        this.co2Low = co2Low;
        this.co2High = co2High;
        this.humidityLow = humidityLow;
        this.humidityHigh = humidityHigh;
    }

    public Profile(){}

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public float getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(float temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public float getTemperatureHight() {
        return temperatureHight;
    }

    public void setTemperatureHight(float temperatureHight) {
        this.temperatureHight = temperatureHight;
    }

    public float getCo2Low() {
        return co2Low;
    }

    public void setCo2Low(float co2Low) {
        this.co2Low = co2Low;
    }

    public float getCo2High() {
        return co2High;
    }

    public void setCo2High(float co2High) {
        this.co2High = co2High;
    }

    public float getHumidityLow() {
        return humidityLow;
    }

    public void setHumidityLow(float humidityLow) {
        this.humidityLow = humidityLow;
    }

    public float getHumidityHigh() {
        return humidityHigh;
    }

    public void setHumidityHigh(float humidityHigh) {
        this.humidityHigh = humidityHigh;
    }
}
