package com.example.grinhouseapp.model;
import java.sql.Timestamp;

public class ACState {

    private int acStateId;
    private boolean heaterOn;
    private boolean coolerOn;
    private Timestamp stateDateTime;
    private int greenhouseId;

    public ACState(int acStateId,boolean heaterOn, boolean coolerOn, Timestamp stateDateTime, int greenhouseId)
    {
        this.acStateId = acStateId;
        this.coolerOn = coolerOn;
        this.heaterOn = heaterOn;
        this.stateDateTime = stateDateTime;
        this.greenhouseId = greenhouseId;
    }

    public int getAcStateId() {
        return acStateId;
    }

    public void setAcStateId(int acStateId) {
        this.acStateId = acStateId;
    }

    public boolean isCoolerOn() {
        return coolerOn;
    }

    public boolean isHeaterOn() {
        return heaterOn;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public Timestamp getStateDateTime() {
        return stateDateTime;
    }

    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public void setCoolerOn(boolean coolerOn) {
        this.coolerOn = coolerOn;
    }

    public void setHeaterOn(boolean heaterOn) {
        this.heaterOn = heaterOn;
    }

    public void setStateDateTime(Timestamp stateDateTime) {
        this.stateDateTime = stateDateTime;
    }
}
